package DKSPACE.PhamarERP.general.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.general.criteria.GenJobTitleCriteria;
import DKSPACE.PhamarERP.general.model.GenJobTitle;
import DKSPACE.PhamarERP.general.repository.GenJobTitleRepository;
import DKSPACE.PhamarERP.general.service.GenJobTitleService;
import DKSPACE.PhamarERP.general.service.criteria.GenJobTitleQueryService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenJobTitleServiceImpl extends AbstractBaseCRUDService<GenJobTitle, GenJobTitleRepository> implements GenJobTitleService {
    
    private final FilterService<GenJobTitle,GenJobTitleCriteria> queryService;
    
    protected GenJobTitleServiceImpl(GenJobTitleRepository repository,
                                       GenJobTitleQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<GenJobTitle> criteria) {
        if (criteria instanceof GenJobTitleCriteria contractCriteria) {
            return queryService.findByCriteria(contractCriteria, pageable, repository::findAll);
        }
        log.error("findByCriteria criteria must be GenJobTitleCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}
