package DKSPACE.PhamarERP.general.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.general.criteria.GenOfficerLevelCriteria;
import DKSPACE.PhamarERP.general.model.GenOfficerLevel;
import DKSPACE.PhamarERP.general.repository.GenOfficerLevelRepository;
import DKSPACE.PhamarERP.general.service.GenOfficerLevelService;
import DKSPACE.PhamarERP.general.service.criteria.GenOfficerLevelQueryService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenOfficerLevelServiceImpl extends AbstractBaseCRUDService<GenOfficerLevel, GenOfficerLevelRepository> implements GenOfficerLevelService {
    
    private final FilterService<GenOfficerLevel,GenOfficerLevelCriteria> queryService;
    
    protected GenOfficerLevelServiceImpl(GenOfficerLevelRepository repository,
                                         GenOfficerLevelQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<GenOfficerLevel> criteria) {
        if (criteria instanceof GenOfficerLevelCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable, repository::findAll);
        }
        log.error("findByCriteria criteria must be GenOfficerLevelCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}