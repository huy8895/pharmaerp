package DKSPACE.PhamarERP.crm.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.crm.criteria.CrmLeadItemCriteria;
import DKSPACE.PhamarERP.crm.model.CrmLeadItem;
import DKSPACE.PhamarERP.crm.repository.CrmLeadItemRepository;
import DKSPACE.PhamarERP.crm.service.CrmLeadItemService;
import DKSPACE.PhamarERP.crm.service.criteria.CrmLeadItemQueryService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CrmLeadItemServiceImpl extends AbstractBaseCRUDService<CrmLeadItem, CrmLeadItemRepository> implements CrmLeadItemService {
    
    private final FilterService<CrmLeadItem,CrmLeadItemCriteria> queryService;
    
    protected CrmLeadItemServiceImpl(CrmLeadItemRepository repository,
                                       CrmLeadItemQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<CrmLeadItem> criteria) {
        if (criteria instanceof CrmLeadItemCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable, repository::findAll);
        }
        log.error("findByCriteria criteria must be CrmLeadItemCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}