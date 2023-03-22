package DKSPACE.PhamarERP.user.service;

import DKSPACE.PhamarERP.basecrud.BaseCRUDService;
import DKSPACE.PhamarERP.user.dto.user_profile.UserProfileReqDto;
import DKSPACE.PhamarERP.user.model.UserProfile;

public interface UserProfileService extends BaseCRUDService<UserProfile> {
	Object getUserProfile(Long userId);
	
	Object updateUserProfile(UserProfileReqDto dto);
}