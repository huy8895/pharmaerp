package DKSPACE.PhamarERP.service;

import DKSPACE.PhamarERP.basecrud.BaseCRUDService;
import DKSPACE.PhamarERP.master_data.dto.user_profile.UserProfileReqDto;
import DKSPACE.PhamarERP.master_data.entity.UserProfile;

public interface UserProfileService extends BaseCRUDService<UserProfile> {
	Object getUserProfile(Long userId);
	
	Object updateUserProfile(UserProfileReqDto dto);
}