package DKSPACE.PhamarERP.user.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.query.Criteria;
import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ServerException;
import DKSPACE.PhamarERP.user.dto.criteria.UserCoursCriteria;
import DKSPACE.PhamarERP.user.model.UserCours;
import DKSPACE.PhamarERP.user.repository.UserCoursRepository;
import DKSPACE.PhamarERP.user.service.UserCoursService;
import DKSPACE.PhamarERP.user.service.criteria.UserCoursQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserCoursServiceImpl extends AbstractBaseCRUDService<UserCours, UserCoursRepository> implements UserCoursService {
    
    private final FilterService<UserCours,UserCoursCriteria> queryService;
    
    protected UserCoursServiceImpl(UserCoursRepository repository,
                                   UserCoursQueryService queryService) {
        super(repository);
        this.queryService = queryService;
    }
    
    @Override
    public Object findByCriteria(Pageable pageable, Criteria<UserCours> criteria) {
        if (criteria instanceof UserCoursCriteria implCriteria) {
            return queryService.findByCriteria(implCriteria, pageable, repository::findAll);
        }
        log.error("findByCriteria criteria must be UserCoursCriteria");
        throw new ServerException(ApiResponseInfo.INTERNAL_SERVER_ERROR);
    }
}