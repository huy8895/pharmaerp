package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmCompanyCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmCompany;
import DKSPACE.PhamarERP.repository.crm.CrmCompanyRepository;
import DKSPACE.PhamarERP.service.CrmCompanyService;
import DKSPACE.PhamarERP.service.criteria.CrmCompanyQueryService;
import DKSPACE.PhamarERP.service.criteria.FilterService;
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