package DKSPACE.PhamarERP.general.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.general.criteria.GenWorkLocationCriteria;
import DKSPACE.PhamarERP.general.model.GenWorkLocation;
import DKSPACE.PhamarERP.general.repository.GenWorkLocationRepository;
import DKSPACE.PhamarERP.general.service.GenWorkLocationService;
import DKSPACE.PhamarERP.general.service.criteria.GenWorkLocationQueryService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenWorkLocationServiceImpl extends AbstractBaseCRUDService<GenWorkLocation, GenWorkLocationRepository> implements GenWorkLocationService {
    
    private final FilterService<GenWorkLocation,GenWorkLocationCriteria> queryService;
    
    protected GenWorkLocationServiceImpl(GenWorkLocationRepository repository,
                                         GenWorkLocationQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<GenWorkLocation> criteria) {
        if (criteria instanceof GenWorkLocationCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable, repository::findAll);
        }
        log.error("findByCriteria criteria must be GenWorkLocationCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}