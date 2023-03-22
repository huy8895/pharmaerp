package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.dto.criteria.CrmContactCriteria;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmContact;
import DKSPACE.PhamarERP.repository.crm.CrmContactRepository;
import DKSPACE.PhamarERP.service.CrmContactService;
import DKSPACE.PhamarERP.service.criteria.CrmContactQueryService;
import DKSPACE.PhamarERP.service.criteria.FilterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CrmContactServiceImpl extends AbstractBaseCRUDService<CrmContact, CrmContactRepository> implements CrmContactService {
    
    private final FilterService<CrmContact,CrmContactCriteria> queryService;
    
    protected CrmContactServiceImpl(CrmContactRepository repository,
                                       CrmContactQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<CrmContact> criteria) {
        if (criteria instanceof CrmContactCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable, repository::findAll);
        }
        log.error("findByCriteria criteria must be CrmContactCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}