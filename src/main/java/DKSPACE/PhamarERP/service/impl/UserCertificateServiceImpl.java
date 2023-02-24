package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.master_data.entity.UserCertificate;
import DKSPACE.PhamarERP.repository.UserCertificateRepository;
import DKSPACE.PhamarERP.service.UserCertificateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserCertificateServiceImpl extends AbstractBaseCRUDService<UserCertificate, UserCertificateRepository> implements UserCertificateService {
    protected UserCertificateServiceImpl(UserCertificateRepository repository) {
        super(repository);
    }
}
