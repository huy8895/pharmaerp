package DKSPACE.PhamarERP.general.service;

import DKSPACE.PhamarERP.general.dto.upload.GenUploadDto;
import DKSPACE.PhamarERP.general.enums.ObjectField;
import DKSPACE.PhamarERP.general.enums.ObjectType;
import org.springframework.web.multipart.MultipartFile;

public interface GenUploadService {
    GenUploadDto upload(MultipartFile file);

    GenUploadDto download(Long id);
    
    GenUploadDto upload(ObjectType objectType, ObjectField objectField, Long objectId, MultipartFile file);
}