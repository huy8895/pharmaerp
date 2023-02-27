package DKSPACE.PhamarERP.auth.service.impl;

import DKSPACE.PhamarERP.auth.mapper.PermissionMapper;
import DKSPACE.PhamarERP.auth.repository.PermissionRepository;
import DKSPACE.PhamarERP.auth.service.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository repository;
    private final PermissionMapper permissionMapper;

    @Override
    public Object getAll() {
        return repository.findAll()
                         .stream()
                         .map(permissionMapper::toDTO)
                         .toList();
    }
}
