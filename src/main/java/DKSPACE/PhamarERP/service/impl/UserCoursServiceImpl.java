package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.master_data.entity.UserCours;
import DKSPACE.PhamarERP.repository.UserCoursRepository;
import DKSPACE.PhamarERP.service.UserCoursService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserCoursServiceImpl extends AbstractBaseCRUDService<UserCours, UserCoursRepository> implements UserCoursService {
    protected UserCoursServiceImpl(UserCoursRepository repository) {
        super(repository);
    }
}
