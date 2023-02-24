package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.master_data.entity.UserProfile;
import DKSPACE.PhamarERP.repository.UserProfileRepository;
import DKSPACE.PhamarERP.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserProfileServiceImpl extends AbstractBaseCRUDService<UserProfile, UserProfileRepository> implements UserProfileService {
    protected UserProfileServiceImpl(UserProfileRepository repository) {
        super(repository);
    }
}
