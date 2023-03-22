package DKSPACE.PhamarERP.general.service.impl;

import DKSPACE.PhamarERP.general.dto.upload.GenUploadDto;
import DKSPACE.PhamarERP.general.model.GenUpload;
import DKSPACE.PhamarERP.general.repository.GenUploadRepository;
import DKSPACE.PhamarERP.general.service.GenUploadService;
import DKSPACE.PhamarERP.helper.excel.FileUtils;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class GenUploadServiceImpl implements GenUploadService {
    private final GenUploadRepository repository;

    @Override
    public GenUploadDto upload(MultipartFile file) {
        final String contentType = file.getContentType();
        if (contentType == null){
            log.error("error upload contentType == null");
            throw new ClientException(ApiResponseInfo.BAD_REQUEST);
        }

        byte[] data = getBytes(file);
        final String originalFilename = file.getOriginalFilename();
        GenUpload upload = GenUpload.builder()
                                    .contentType(contentType)
                                    .data(data)
                                    .originalName(originalFilename)
                                    .fileName(FileUtils.generateFileName(originalFilename))
                                    .size((float) data.length)
                                    .extension(StringUtils.getFilenameExtension(originalFilename))
                                    .build();
        GenUpload saveUpload = repository.save(upload);
        return getGenUploadDto(saveUpload, new byte[]{});
    }

    private byte[] getBytes(MultipartFile file) {
        byte[] compress = new byte[0];
        try {
            compress = file.getBytes();
        } catch (IOException e) {
            throw new ClientException(ApiResponseInfo.BAD_REQUEST);
        }
        return compress;
    }

    private GenUploadDto getGenUploadDto(GenUpload saveUpload, byte[] data) {
        return GenUploadDto.builder()
                           .id(saveUpload.getId())
                           .originalName(saveUpload.getOriginalName())
                           .fileName(saveUpload.getFileName())
                           .extension(saveUpload.getExtension())
                           .contentType(saveUpload.getContentType())
                           .data(data)
                           .size(saveUpload.getSize())
                           .build();
    }


    @Override
    public GenUploadDto download(Long id) {
        final GenUpload upload = repository.findById(id)
                                        .orElseThrow();
        return getGenUploadDto(upload, upload.getData());
    }
}
