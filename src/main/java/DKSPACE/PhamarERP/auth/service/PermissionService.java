package DKSPACE.PhamarERP.auth.service;

import org.springframework.data.domain.Pageable;

public interface PermissionService {
    Object getAll(Pageable pageable);
}
