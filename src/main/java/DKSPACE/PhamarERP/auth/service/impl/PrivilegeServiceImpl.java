package DKSPACE.PhamarERP.auth.service.impl;

import DKSPACE.PhamarERP.auth.repository.PrivilegeRepository;
import DKSPACE.PhamarERP.auth.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrivilegeServiceImpl implements PrivilegeService {
    private final PrivilegeRepository repository;
    @Override
    public Object getAll() {
        return repository.findAll();
    }
}
