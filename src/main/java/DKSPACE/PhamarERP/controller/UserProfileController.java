package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.auth.aop.HasPermission;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.master_data.dto.user_profile.UserProfileReqDto;
import DKSPACE.PhamarERP.service.UserProfileService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user-profiles")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class UserProfileController {
	private final UserProfileService service;
	
	/**
	 * 1. Xem hồ sơ người dùng - View user profile
	 */
	@GetMapping("/{userId}")
	@HasPermission(value = PermissionKeyEnum.VIEW_USER_PROFILE, acceptCurrentUser = true)
	public Object getUserProfile(@PathVariable("userId") Long userId){
		return service.getUserProfile(userId);
	}
	
	
	/**
	 * 2. Cập nhật hồ sơ người dùng - Update user profile
	 */
	@PutMapping("/{userId}")
	@HasPermission(value = PermissionKeyEnum.UPDATE_USER_PROFILE, acceptCurrentUser = true)
	public Object updateUserProfile(@PathVariable("userId") Long userId, @Valid @RequestBody UserProfileReqDto dto){
		return service.updateUserProfile(dto);
	}
}