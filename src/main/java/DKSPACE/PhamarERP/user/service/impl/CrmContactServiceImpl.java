package DKSPACE.PhamarERP.user.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.crm.criteria.CrmContactCriteria;
import DKSPACE.PhamarERP.crm.model.CrmContact;
import DKSPACE.PhamarERP.crm.repository.CrmContactRepository;
import DKSPACE.PhamarERP.crm.service.CrmContactService;
import DKSPACE.PhamarERP.crm.service.criteria.CrmContactQueryService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
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