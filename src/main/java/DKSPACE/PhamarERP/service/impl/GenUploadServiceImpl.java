package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.repository.GenUploadRepository;
import DKSPACE.PhamarERP.service.GenUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GenUploadServiceImpl implements GenUploadService {
    private final GenUploadRepository repository;
}
