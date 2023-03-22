package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserCertificateCriteria;
import DKSPACE.PhamarERP.master_data.entity.UserCertificate;
import DKSPACE.PhamarERP.repository.UserCertificateRepository;
import DKSPACE.PhamarERP.service.UserCertificateService;
import DKSPACE.PhamarERP.service.criteria.FilterService;
import DKSPACE.PhamarERP.service.criteria.UserCertificateQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserCertificateServiceImpl extends AbstractBaseCRUDService<UserCertificate, UserCertificateRepository> implements UserCertificateService {
    
    private final FilterService<UserCertificate,UserCertificateCriteria> queryService;
    
    protected UserCertificateServiceImpl(UserCertificateRepository repository,
                                       UserCertificateQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<UserCertificate> criteria) {
        if (criteria instanceof UserCertificateCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable, repository::findAll);
        }
        log.error("findByCriteria criteria must be UserCertificateCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}