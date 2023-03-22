package DKSPACE.PhamarERP.general.service;

import DKSPACE.PhamarERP.general.dto.upload.GenUploadDto;
import org.springframework.web.multipart.MultipartFile;

public interface GenUploadService {
    GenUploadDto upload(MultipartFile file);

    GenUploadDto download(Long id);
}