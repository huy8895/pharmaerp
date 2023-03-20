package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenWorkLocationCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenWorkLocation;
import DKSPACE.PhamarERP.repository.GenWorkLocationRepository;
import DKSPACE.PhamarERP.service.GenWorkLocationService;
import DKSPACE.PhamarERP.service.criteria.FilterService;
import DKSPACE.PhamarERP.service.criteria.GenWorkLocationQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenWorkLocationServiceImpl extends AbstractBaseCRUDService<GenWorkLocation, GenWorkLocationRepository> implements GenWorkLocationService {
    
    private final FilterService<GenWorkLocationCriteria> queryService;
    
    protected GenWorkLocationServiceImpl(GenWorkLocationRepository repository,
                                         GenWorkLocationQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<GenWorkLocation> criteria) {
        if (criteria instanceof GenWorkLocationCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable);
        }
        log.error("findByCriteria criteria must be GenWorkLocationCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}