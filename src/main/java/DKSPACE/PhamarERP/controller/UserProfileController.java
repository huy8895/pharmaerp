package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.auth.aop.HasPermission;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.master_data.dto.user_profile.UserProfileReqDto;
import DKSPACE.PhamarERP.master_data.dto.user_profile.UserProfileResDto;
import DKSPACE.PhamarERP.master_data.entity.UserProfile;
import DKSPACE.PhamarERP.service.UserProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user-profiles")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "UserProfile", description = "Hồ sơ người dùng")
public class UserProfileController {
	private final UserProfileService service;
	
	/**
	 * 1. Xem hồ sơ người dùng - View user profile
	 */
	@GetMapping("/{userId}")
	@HasPermission(value = PermissionKeyEnum.VIEW_USER_PROFILE, acceptCurrentUser = true)
	@Operation(summary = "Lấy hồ sơ người dùng theo id")
	@ApiResponse(responseCode = "200", description = "Tìm thấy hồ sơ người dùng",
			content = @Content(schema = @Schema(implementation = UserProfileResDto.class)))
	public Object getUserProfile(@PathVariable("userId") Long userId){
		return service.getUserProfile(userId);
	}
	
	
	/**
	 * 2. Cập nhật hồ sơ người dùng - Update user profile
	 */
	@PutMapping("/{userId}")
	@HasPermission(value= PermissionKeyEnum.UPDATE_USER_PROFILE, acceptCurrentUser= true)
	@Operation(summary=  "Cập nhật hồ sơ người dùng theo id")
	@ApiResponse(responseCode = "200", description = "Cập nhật hồ sơ người dùng thành công",
			content = @Content(schema = @Schema(implementation = UserProfile.class)))
	public Object updateUserProfile(@PathVariable("userId") Long userId, @Valid @RequestBody UserProfileReqDto dto){
		return service.updateUserProfile(dto);
	}
}