package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.master_data.dto.upload.GenUploadDto;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.service.GenUploadService;
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
@RequestMapping("/api/gen-upload")
@RequiredArgsConstructor
@ResponseWrapper(excludes = {"download"})
public class GenUploadController {
    private final GenUploadService service;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Object upload(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("file : {}", file.getOriginalFilename());
        return service.upload(file);
    }

    @GetMapping("/download/{id}")
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
