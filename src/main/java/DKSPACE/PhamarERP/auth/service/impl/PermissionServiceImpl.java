package DKSPACE.PhamarERP.auth.service.impl;

import DKSPACE.PhamarERP.auth.dto.permission.PermissionDTO;
import DKSPACE.PhamarERP.auth.mapper.PermissionMapper;
import DKSPACE.PhamarERP.auth.repository.PermissionRepository;
import DKSPACE.PhamarERP.auth.service.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository repository;
    private final PermissionMapper permissionMapper;

    @Override
    public Page<PermissionDTO> getAll(Pageable pageable) {
        return repository.findAll(pageable)
                         .map(permissionMapper::toDTO);
    }
}
