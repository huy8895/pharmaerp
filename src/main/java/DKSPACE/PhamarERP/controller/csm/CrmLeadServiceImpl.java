package DKSPACE.PhamarERP.controller.csm;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLead;
import DKSPACE.PhamarERP.repository.crm.CrmLeadRepository;
import DKSPACE.PhamarERP.service.criteria.FilterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CrmLeadServiceImpl extends AbstractBaseCRUDService<CrmLead, CrmLeadRepository> implements CrmLeadService {
    
    private final FilterService<CrmLeadCriteria> queryService;
    
    protected CrmLeadServiceImpl(CrmLeadRepository repository,
                                       CrmLeadQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<CrmLead> criteria) {
        if (criteria instanceof CrmLeadCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable);
        }
        log.error("findByCriteria criteria must be CrmLeadCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}