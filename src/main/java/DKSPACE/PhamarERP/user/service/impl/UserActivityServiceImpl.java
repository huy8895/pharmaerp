package DKSPACE.PhamarERP.user.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.user.dto.criteria.UserActivityCriteria;
import DKSPACE.PhamarERP.user.model.UserActivity;
import DKSPACE.PhamarERP.user.repository.UserActivityRepository;
import DKSPACE.PhamarERP.user.service.UserActivityService;
import DKSPACE.PhamarERP.user.service.criteria.UserActivityQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserActivityServiceImpl extends AbstractBaseCRUDService<UserActivity, UserActivityRepository> implements UserActivityService {
    
    private final FilterService<UserActivity,UserActivityCriteria> queryService;
    
    protected UserActivityServiceImpl(UserActivityRepository repository,
                                       UserActivityQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<UserActivity> criteria) {
        if (criteria instanceof UserActivityCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable, repository::findAll);
        }
        log.error("findByCriteria criteria must be UserActivityCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}