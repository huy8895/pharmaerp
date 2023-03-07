package DKSPACE.PhamarERP.basecrud;

import DKSPACE.PhamarERP.helper.excel.ReflectUtils;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class BaseCrudUtils {

    private static final List<String> DONT_COPY_FIELD =
            List.of("id",
                    "createdAt",
                    "updatedAt",
                    "deletedFlag");
    public static Set<String> getNullPropertyNames (Object source) {
        List<Field> allField = ReflectUtils.getAllField(source.getClass());
        return allField.stream().filter(field -> {
            try {
                field.setAccessible(true);
                return field.get(source) == null;
            } catch (Exception e) {
                return true;
            }
        }).map(Field::getName).collect(Collectors.toSet());
    }

    // then use Spring BeanUtils to copy and ignore null using our function
    public static void update(Object src, Object target) {

        final var nullPropertyNames = getNullPropertyNames(src);
        nullPropertyNames.addAll(DONT_COPY_FIELD);

        BeanUtils.copyProperties(src, target, nullPropertyNames.toArray(String[]::new));
    }
}
