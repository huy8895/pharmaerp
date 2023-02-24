package DKSPACE.PhamarERP.master_data.dto;

import lombok.*;

/**
 * A DTO for the {@link DKSPACE.PhamarERP.master_data.entity.GenUpload} entity
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