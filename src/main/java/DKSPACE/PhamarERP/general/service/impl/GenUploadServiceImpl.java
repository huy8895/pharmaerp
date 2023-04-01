package DKSPACE.PhamarERP.general.service.impl;

import DKSPACE.PhamarERP.general.dto.upload.GenUploadDto;
import DKSPACE.PhamarERP.general.dto.upload.UploadableDto;
import DKSPACE.PhamarERP.general.enums.ObjectField;
import DKSPACE.PhamarERP.general.enums.ObjectType;
import DKSPACE.PhamarERP.general.model.GenUpload;
import DKSPACE.PhamarERP.general.repository.GenUploadRepository;
import DKSPACE.PhamarERP.general.service.GenUploadService;
import DKSPACE.PhamarERP.general.service.UploadableService;
import DKSPACE.PhamarERP.helper.excel.FileUtils;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ClientException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class GenUploadServiceImpl implements GenUploadService {
    private final GenUploadRepository repository;
    private final UploadableService uploadableService;
    private final EntityManager entityManager;
    
    @Autowired
    private Validator validator;
    
    @Override
    public GenUploadDto upload(MultipartFile file) {
        final var saveUpload = this.saveUpload(file);
        return getGenUploadDto(saveUpload, new byte[]{});
    }
    
    private GenUpload saveUpload(MultipartFile file) {
        final String contentType = file.getContentType();
        if (contentType == null) {
            log.error("error upload contentType == null");
            throw new ClientException(ApiResponseInfo.BAD_REQUEST);
        }
        
        byte[] data = getBytes(file);
        final String originalFilename = file.getOriginalFilename();
        final var upload = GenUpload.builder()
                                    .contentType(contentType)
                                    .data(data)
                                    .originalName(originalFilename)
                                    .fileName(FileUtils.generateFileName(originalFilename))
                                    .size((float) data.length)
                                    .extension(StringUtils.getFilenameExtension(originalFilename))
                                    .build();
        final var validate = validator.validate(upload);
        if (!validate.isEmpty()) {
            throw new ConstraintViolationException(validate);
        }
        return repository.save(upload);
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
    
    @Override
    @Transactional
    public GenUploadDto upload(ObjectType objectType, ObjectField objectField, Long objectId, MultipartFile file) {
        if (!this.isObjectExistById(objectId, objectType)){
            throw new NoSuchElementException(String.format("No value present for object: %s, id : %s" , objectType ,objectId));
        }
        final var upload  = this.saveUpload(file);
        Object save = uploadableService.save(upload.getId(), objectType, objectField, objectId, upload);
        return getGenUploadDto(upload, new byte[]{});
    }
    
    private boolean isObjectExistById(Long objectId, ObjectType objectType) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final var cq = cb.createQuery(objectType.getaClass());
        final var product = cq.from(objectType.getaClass());
        final var codePredicate = cb.equal(product.get("id"), objectId);
        cq.where(codePredicate);
        final var query = entityManager.createQuery(cq);
        return !query.getResultList().isEmpty();
    }
    
    @Override
    public Object upload(UploadableDto dto) {
        final var byIdIn = repository.findByIdIn(dto.getGenUploadId());
        return uploadableService.save(byIdIn, dto.getObjectType(), dto.getObjectField(),
                                      dto.getObjectId());
    }
    
}
