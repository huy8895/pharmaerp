package DKSPACE.PhamarERP.crm.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.crm.criteria.CrmCompanyCriteria;
import DKSPACE.PhamarERP.crm.model.CrmCompany;
import DKSPACE.PhamarERP.crm.repository.CrmCompanyRepository;
import DKSPACE.PhamarERP.crm.service.CrmCompanyService;
import DKSPACE.PhamarERP.crm.service.criteria.CrmCompanyQueryService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CrmCompanyServiceImpl extends AbstractBaseCRUDService<CrmCompany, CrmCompanyRepository> implements CrmCompanyService {
    
    private final FilterService<CrmCompany,CrmCompanyCriteria> queryService;
    
    protected CrmCompanyServiceImpl(CrmCompanyRepository repository,
                                       CrmCompanyQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<CrmCompany> criteria) {
        if (criteria instanceof CrmCompanyCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable, repository::findAll);
        }
        log.error("findByCriteria criteria must be CrmCompanyCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}