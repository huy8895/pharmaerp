package DKSPACE.PhamarERP.user.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.basecrud.BaseCrudUtils;
import DKSPACE.PhamarERP.user.dto.user_profile.UserProfileReqDto;
import DKSPACE.PhamarERP.user.dto.user_profile.UserProfileResDto;
import DKSPACE.PhamarERP.user.mapper.UserProfileMapper;
import DKSPACE.PhamarERP.user.model.UserProfile;
import DKSPACE.PhamarERP.user.repository.UserProfileRepository;
import DKSPACE.PhamarERP.user.service.UserProfileService;
import DKSPACE.PhamarERP.user.service.UserService;
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
		userService.findOne(dto.getUserId());
		UserProfile userProfile = mapper.toEntity(dto);
		return this.partialUpdate(userProfile);
	}
	
	@Override
	public UserProfile partialUpdate(UserProfile userProfile) {
		return repository.findByUserId(userProfile.getUserId())
		                 .map(existingProfile -> {
			                 BaseCrudUtils.update(userProfile, existingProfile);
			                 return this.save(existingProfile);
		                 })
		                 .orElseGet(() -> this.save(userProfile));
	}
}