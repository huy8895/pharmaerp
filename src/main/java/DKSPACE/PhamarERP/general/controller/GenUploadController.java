package DKSPACE.PhamarERP.general.controller;

import DKSPACE.PhamarERP.general.dto.upload.GenUploadDto;
import DKSPACE.PhamarERP.general.dto.upload.UploadableDto;
import DKSPACE.PhamarERP.general.enums.ObjectField;
import DKSPACE.PhamarERP.general.enums.ObjectType;
import DKSPACE.PhamarERP.general.service.GenUploadService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/gen-uploads")
@RequiredArgsConstructor
@ResponseWrapper(excludes = {"download"})
@Tag(name = "GenUpload", description = "The GenUpload API")
@SecurityRequirement(name = "bearerAuth") // indicate that all endpoints require authentication
public class GenUploadController {
    private final GenUploadService service;
    
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Tải lên một tệp tin") 
    public Object upload(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("file : {}", file.getOriginalFilename());
        return service.upload(file);
    }
    
    @PostMapping(value = "/upload/{type}/{objectId}/{field}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Tải lên một tệp tin cho một đối tượng cụ thể v1")
    public Object uploadable(@RequestParam("file") MultipartFile file,
                         @PathVariable("type") ObjectType objectType,
                         @PathVariable("field") ObjectField objectField,
                         @PathVariable("objectId") Long objectId
                         ) throws IOException {
        log.info("uploadable : {}", file.getOriginalFilename());
        return service.upload(objectType, objectField, objectId, file);
    }
    
    @PostMapping(value = "/uploadable")
    @Operation(summary = "Tải lên một tệp tin cho một đối tượng cụ thể v2")
    public Object uploadable(@RequestBody UploadableDto dto) {
        log.info("uploadable : {}", dto);
        return service.upload(dto);
    }
    
    @GetMapping("/download/{id}")
    @Operation(summary = "Tải xuống một tệp tin theo id") 
    public ResponseEntity<byte[]> download(@PathVariable Long id) {
        log.info("download id : {}", id);
        GenUploadDto dto = service.download(id);
        HttpHeaders headers = getHttpHeaders(dto);
        return ResponseEntity.status(HttpStatus.OK)
                             .headers(headers)
                             .body(dto.getData());
    }
    
    private HttpHeaders getHttpHeaders(GenUploadDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(dto.getContentType()));
        headers.set(HttpHeaders.CONTENT_DISPOSITION,
                    "inline; filename=" + dto.getFileName() + "." + dto.getExtension());
        return headers;
    }
}
