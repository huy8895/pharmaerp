package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenJobTitleCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenJobTitle;
import DKSPACE.PhamarERP.repository.GenJobTitleRepository;
import DKSPACE.PhamarERP.service.GenJobTitleService;
import DKSPACE.PhamarERP.service.criteria.FilterService;
import DKSPACE.PhamarERP.service.criteria.GenJobTitleQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenJobTitleServiceImpl extends AbstractBaseCRUDService<GenJobTitle, GenJobTitleRepository> implements GenJobTitleService {
    
    private final FilterService<GenJobTitleCriteria> queryService;
    
    protected GenJobTitleServiceImpl(GenJobTitleRepository repository,
                                       GenJobTitleQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<GenJobTitle> criteria) {
        if (criteria instanceof GenJobTitleCriteria contractCriteria) {
            return queryService.findByCriteria(contractCriteria, pageable);
        }
        log.error("findByCriteria criteria must be GenJobTitleCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}
