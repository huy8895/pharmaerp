package DKSPACE.PhamarERP.controller.csm;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmCompany;
import DKSPACE.PhamarERP.repository.crm.CrmCompanyRepository;
import DKSPACE.PhamarERP.service.criteria.FilterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CrmCompanyServiceImpl extends AbstractBaseCRUDService<CrmCompany, CrmCompanyRepository> implements CrmCompanyService {
    
    private final FilterService<CrmCompanyCriteria> queryService;
    
    protected CrmCompanyServiceImpl(CrmCompanyRepository repository,
                                       CrmCompanyQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<CrmCompany> criteria) {
        if (criteria instanceof CrmCompanyCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable);
        }
        log.error("findByCriteria criteria must be CrmCompanyCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}