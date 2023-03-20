package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.helper.query.Criteria;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserActivityCriteria;
import DKSPACE.PhamarERP.master_data.entity.UserActivity;
import DKSPACE.PhamarERP.repository.UserActivityRepository;
import DKSPACE.PhamarERP.service.UserActivityService;
import DKSPACE.PhamarERP.service.criteria.FilterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserActivityServiceImpl extends AbstractBaseCRUDService<UserActivity, UserActivityRepository> implements UserActivityService {
    
    private final FilterService<UserActivityCriteria> queryService;
    
    protected UserActivityServiceImpl(UserActivityRepository repository,
                                       ContractServiceImpl.UserActivityQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<UserActivity> criteria) {
        if (criteria instanceof UserActivityCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable);
        }
        log.error("findByCriteria criteria must be UserActivityCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}