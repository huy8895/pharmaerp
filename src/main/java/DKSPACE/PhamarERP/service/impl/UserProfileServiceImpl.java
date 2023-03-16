package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.mapper.UserProfileMapper;
import DKSPACE.PhamarERP.master_data.dto.user_profile.UserProfileResDto;
import DKSPACE.PhamarERP.master_data.dto.user_profile.UserProfileReqDto;
import DKSPACE.PhamarERP.master_data.entity.UserProfile;
import DKSPACE.PhamarERP.repository.UserProfileRepository;
import DKSPACE.PhamarERP.service.UserProfileService;
import DKSPACE.PhamarERP.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserProfileServiceImpl extends AbstractBaseCRUDService<UserProfile, UserProfileRepository> implements UserProfileService {
	private final UserService userService;
	private final UserProfileMapper mapper;
	protected UserProfileServiceImpl(UserProfileRepository repository,
	                                 UserService userService,
	                                 UserProfileMapper mapper) {
		super(repository);
		this.userService = userService;
		this.mapper = mapper;
	}
	
	@Override
	public UserProfile findOne(Long userID) {
		return repository.findByUserId(userID)
		                 .orElse(UserProfile.builder()
		                                    .userId(userID)
		                                    .build());
	}
	
	@Override
	public UserProfileResDto getUserProfile(Long userId) {
		UserProfile userProfile = this.findOne(userId);
		return mapper.toDTO(userProfile);
	}
	
	@Override
	public Object updateUserProfile(UserProfileReqDto dto) {
//		User user = userService.findOne(dto.getId());
//		UserProfile userProfile = this.save(UserProfile.builder()
//		                                        .user(user)
//		                                        .build());
//		return this.partialUpdate()
		return null;
	}
}