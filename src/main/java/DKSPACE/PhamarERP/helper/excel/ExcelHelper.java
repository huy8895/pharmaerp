package DKSPACE.PhamarERP.helper.excel;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelHelper {
    <E> List<E> readFile(MultipartFile file, Class<E> eClass);
    <E> byte[] writeFile(List<E> list, Class<E> eClass);

    <E> byte[] exportTemplate(Class<E> eClass);

    default <E> List<CellDTO> getCellHeader(Class<E> eClass, String... ignoreFields) {
        return ReflectUtils.generateCellHeader(eClass, ignoreFields);
    }

    default <E> List<CellDTO> getCellDTOS(E element, String... ignoreFields) {
        return ReflectUtils.generateCellDTO(element, ignoreFields);
    }
}
