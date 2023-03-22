package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmLeadItemCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmLeadItem;
import DKSPACE.PhamarERP.repository.crm.CrmLeadItemRepository;
import DKSPACE.PhamarERP.service.CrmLeadItemService;
import DKSPACE.PhamarERP.service.criteria.CrmLeadItemQueryService;
import DKSPACE.PhamarERP.service.criteria.FilterService;
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