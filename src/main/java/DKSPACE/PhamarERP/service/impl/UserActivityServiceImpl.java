package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.master_data.entity.UserActivity;
import DKSPACE.PhamarERP.repository.UserActivityRepository;
import DKSPACE.PhamarERP.service.UserActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserActivityServiceImpl extends AbstractBaseCRUDService<UserActivity, UserActivityRepository> implements UserActivityService {
    protected UserActivityServiceImpl(UserActivityRepository repository) {
        super(repository);
    }
}
