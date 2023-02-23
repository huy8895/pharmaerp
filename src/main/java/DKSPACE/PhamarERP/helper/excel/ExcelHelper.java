package DKSPACE.PhamarERP.helper.excel;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelHelper {
    <E> List<E> readFile(MultipartFile file, Class<E> eClass);
    <E> byte[] writeFile(List<E> list, Class<E> eClass);

    <E> byte[] exportTemplate(List<E> list, Class<E> eClass);

    default <E> List<CellDTO> getCellHeader(Class<E> eClass) {
        return ReflectUtils.generateCellHeader(eClass);
    }

    default <E> List<CellDTO> getCellDTOS(E element) {
        return ReflectUtils.generateCellDTO(element);
    }
}
