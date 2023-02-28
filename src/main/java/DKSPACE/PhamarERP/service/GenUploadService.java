package DKSPACE.PhamarERP.service;

import DKSPACE.PhamarERP.master_data.dto.upload.GenUploadDto;
import org.springframework.web.multipart.MultipartFile;

public interface GenUploadService {
    GenUploadDto upload(MultipartFile file);

    GenUploadDto download(Long id);
}