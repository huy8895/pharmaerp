package DKSPACE.PhamarERP.crm.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.crm.criteria.CrmTagCriteria;
import DKSPACE.PhamarERP.crm.model.CrmTag;
import DKSPACE.PhamarERP.crm.repository.CrmTagRepository;
import DKSPACE.PhamarERP.crm.service.CrmTagService;
import DKSPACE.PhamarERP.crm.service.criteria.CrmTagQueryService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CrmTagServiceImpl extends AbstractBaseCRUDService<CrmTag, CrmTagRepository> implements CrmTagService {
    
    private final FilterService<CrmTag,CrmTagCriteria> queryService;
    
    protected CrmTagServiceImpl(CrmTagRepository repository,
                                       CrmTagQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<CrmTag> criteria) {
        if (criteria instanceof CrmTagCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable, repository::findAll);
        }
        log.error("findByCriteria criteria must be CrmTagCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}