package DKSPACE.PhamarERP.general.dto.upload;

import DKSPACE.PhamarERP.general.model.GenUpload;
import lombok.*;

/**
 * A DTO for the {@link GenUpload} entity
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenUploadDto {
    private Long id;
    private String originalName;
    private String fileName;
    private String extension;
    private String contentType;
    private byte[] data;
    private Float size;
}