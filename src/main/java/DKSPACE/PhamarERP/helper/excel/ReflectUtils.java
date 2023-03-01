package DKSPACE.PhamarERP.helper.excel;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public final class ReflectUtils {
    private ReflectUtils() {
    }

    public static <E> List<CellDTO> generateCellDTO(E entity, String... ignoreFields) {
        Set<String> ignoreFieldNames = Set.of(ignoreFields);
        Class<?> aClass = entity.getClass();
        Class<?> superclass = aClass.getSuperclass();

        List<Field> allField = new ArrayList<>();
        if (superclass != null) {
            allField.addAll(List.of(superclass.getDeclaredFields()));
        }
        allField.addAll(List.of(aClass.getDeclaredFields()));

        AtomicInteger index = new AtomicInteger(0);
        LinkedList<CellDTO> cellDTOS = new LinkedList<>();

        try {
            for (Field declaredField : allField) {
                declaredField.setAccessible(true);
                Object value = declaredField.get(entity);
                String fieldName = declaredField.getName();
                if (ignoreFieldNames.contains(fieldName)) continue;
                CellDTO cellDTO = CellDTO.builder()
                                         .index(index.getAndIncrement())
                                         .fieldName(fieldName)
                                         .build();
                if (value != null) {
                    cellDTO.setValue(value.toString());
                }
                cellDTOS.add(cellDTO);
            }
        } catch (Exception e) {
            log.error("error getCellDTO: {}", e.getMessage());
            throw new RuntimeException("error getCellDTO");
        }

        return cellDTOS;
    }


    public static <E> List<CellDTO> generateCellHeader(Class<E> aClass, String... ignoreFields) {
        Set<String> ignoreFieldNames = Set.of(ignoreFields);
        Class<?> superclass = aClass.getSuperclass();
        List<Field> allField = new ArrayList<>();
        if (superclass != null) {
            allField.addAll(List.of(superclass.getDeclaredFields()));
        }
        allField.addAll(List.of(aClass.getDeclaredFields()));

        AtomicInteger index = new AtomicInteger(0);
        LinkedList<CellDTO> cellDTOS = new LinkedList<>();
        try {
            for (Field declaredField : allField) {
                declaredField.setAccessible(true);
                String fieldName = declaredField.getName();
                if (ignoreFieldNames.contains(fieldName)) continue;
                cellDTOS.add(CellDTO.builder()
                                    .index(index.getAndIncrement())
                                    .fieldName(fieldName)
                                    .build());
            }
        } catch (Exception e) {
            log.error("error getCellDTO: {}", e.getMessage());
            throw new RuntimeException("error getCellDTO");
        }

        return cellDTOS;
    }

    public static List<Field> getAllField(Class<?> aClass) {
        List<Field> allField = new ArrayList<>();
        while (aClass.getSuperclass() != null) {
            var superclass = aClass.getSuperclass();
            allField.addAll(List.of(superclass.getDeclaredFields()));
            allField.addAll(List.of(aClass.getDeclaredFields()));
            aClass = superclass;
        }
        return allField;
    }

    public static <E> List<Method> getAllSetterMethod(Class<E> aClass) {
        return Arrays.stream(aClass.getDeclaredMethods())
                     .filter(method -> method.getName().startsWith("set"))
                     .toList();
    }

    public static  <O, F> F getValue(O obj, String fieldName, Class<F> fClass){
        try {
            Field field = getAllField(obj.getClass()).stream()
                                                     .filter(field1 -> field1.getName()
                                                                             .equals(fieldName))
                                                     .findFirst()
                                                     .orElseThrow();
            field.setAccessible(true);
            return (F) field.get(obj);
        } catch (Exception e) {
            log.error("getValue error: {} {}", e.getClass(), e.getMessage());
            return null;
        }
    }

//    obj.getclass() =>
//    class org.springframework.validation.beanvalidation.SpringValidatorAdapter$ViolationFieldError
}
