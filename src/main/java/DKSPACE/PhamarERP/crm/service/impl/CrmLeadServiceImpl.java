package DKSPACE.PhamarERP.crm.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.crm.criteria.CrmLeadCriteria;
import DKSPACE.PhamarERP.crm.model.CrmLead;
import DKSPACE.PhamarERP.crm.repository.CrmLeadRepository;
import DKSPACE.PhamarERP.crm.service.CrmLeadService;
import DKSPACE.PhamarERP.crm.service.criteria.CrmLeadQueryService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CrmLeadServiceImpl extends AbstractBaseCRUDService<CrmLead, CrmLeadRepository> implements CrmLeadService {
    
    private final FilterService<CrmLead,CrmLeadCriteria> queryService;
    
    protected CrmLeadServiceImpl(CrmLeadRepository repository,
                                       CrmLeadQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<CrmLead> criteria) {
        if (criteria instanceof CrmLeadCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable, repository::findAll);
        }
        log.error("findByCriteria criteria must be CrmLeadCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}