package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.helper.excel.FileUtils;
import DKSPACE.PhamarERP.master_data.dto.GenUploadDto;
import DKSPACE.PhamarERP.master_data.entity.GenUpload;
import DKSPACE.PhamarERP.repository.GenUploadRepository;
import DKSPACE.PhamarERP.service.GenUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class GenUploadServiceImpl implements GenUploadService {
    private final GenUploadRepository repository;

    @Override
    public GenUploadDto upload(MultipartFile file) {

        String contentType = file.getContentType();
        if (contentType == null) throw new RuntimeException("UploadServiceImpl upload invalid contenty");
        byte[] compress = FileUtils.compress(file);
        GenUpload upload = GenUpload.builder()
                                   .contentType(contentType)
                                   .data(compress)
                                   .originalName(file.getOriginalFilename())
                                   .fileName(FileUtils.generateFileName(file))
                                   .size((float) compress.length)
                                   .extension(StringUtils.getFilenameExtension(file.getOriginalFilename()))
                                   .build();
        GenUpload saveUpload = repository.save(upload);
        return getGenUploadDto(saveUpload);
    }

    private GenUploadDto getGenUploadDto(GenUpload saveUpload) {
        return GenUploadDto.builder()
                           .id(saveUpload.getId())
                           .originalName(saveUpload.getOriginalName())
                           .fileName(saveUpload.getFileName())
                           .extension(saveUpload.getExtension())
                           .contentType(saveUpload.getContentType())
                           .data(saveUpload.getData())
                           .size(saveUpload.getSize())
                           .build();
    }


    @Override
    public GenUploadDto download(Long id) {
        final GenUpload upload = repository.findById(id)
                                        .orElseThrow();
        upload.setData(FileUtils.decompress(upload.getData()));
        return getGenUploadDto(upload);
    }
}
