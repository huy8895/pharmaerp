package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.auth.aop.HasPermission;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.helper.excel.FileUtils;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserCriteria;
import DKSPACE.PhamarERP.master_data.dto.user.*;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@ResponseWrapper(excludes = {"exportTemplate","exportUser"})
@Tag(name = "User", description = "Các API để quản lý người dùng")
public class UserController {
    private final UserService service;

    /**
     * 1. Hiển thị danh sách và Filter
     - API trả ra danh sách có phân trang
     - Trong API tích hợp luôn filter theo các cột
     - Đối với cột ID luôn query Bằng
     - Các cột còn lại query like
     - Trong API tích hợp luôn sắp xếp theo các cột (chỉ orderby theo 1 cột, mặc định ID DESC)
     **/
    @GetMapping
    @HasPermission(PermissionKeyEnum.GET_LIST_USER)
    @Operation(summary = "Hiển thị danh sách và filter người dùng", description = "Lấy danh sách người dùng theo các tiêu chí")
    public Object listUser(@ParameterObject Pageable pageable,
                           @ParameterObject UserCriteria userCriteria){
        return service.listUser(userCriteria, pageable);
    }

    /**
     * 2. Tạo mới user
     - Tạo mới toàn bộ các thông tin
     - Password mặc định PharmaERP@2023 -> tạo 1 const lưu cái này
     **/
    @PostMapping
    @HasPermission(PermissionKeyEnum.CREATE_USER)
    @Operation(summary = "Tạo mới người dùng", description = "Tạo một người dùng mới với các thông tin cơ bản")
    public Object createUser(@RequestBody @Valid UserCreateDTO dto){
        return service.createUser(dto);
    }

    /**
     3. Sửa thông tin user
     - Update các thông tin khác ngoại trừ password và is_active vì đã có chức năng riêng
     **/
    @PutMapping
    @HasPermission(PermissionKeyEnum.UPDATE_USER)
    @Operation(summary = "Tạo mới người dùng", description = "Tạo một người dùng mới với các thông tin cơ bản")
    public Object updateUser(@RequestBody @Valid UserUpdateDTO dto){
        return service.updateUser(dto);
    }

    /**
     4. Active/Deactive User
     **/
    @PutMapping("/toggle-active/{id}")
    @HasPermission(PermissionKeyEnum.TOGGLE_ACTIVE_USER)
    @Operation(summary = "Chuyển trạng thái kích hoạt của người dùng", description = "Thay đổi trạng thái kích hoạt của người dùng bằng id")
    public Object toggleActiveUser(@PathVariable Long id){
        return service.toggleActiveUser(id);
    }

    /**
     5. Add role cho User
     - Thêm 1 or nhiều role cho  User
     **/
    @PutMapping("/add-roles")
    @HasPermission(PermissionKeyEnum.ADD_ROLES_USER)
    @Operation(summary = "Thêm role cho người dùng", description = "Thêm một hoặc nhiều role cho người dùng")
    public Object addRolesUser(@RequestBody @Valid UserAddRolesDTO dto){
        return service.updateRolesUser(dto);
    }

    /**
     6. Export User
     - Export all Field ngoại trừ password
     **/
    @GetMapping("/export")
    @Operation(summary = "Xuất người dùng", description = "Xuất tất cả các trường ngoại trừ mật khẩu")
    @HasPermission(PermissionKeyEnum.EXPORT_USER)
    public Object exportUser(){
        return ResponseEntity.status(HttpStatus.OK)
                .headers(FileUtils.genHeadersForExport("export-user"))
                .body(service.exportUser())
                ;
    }

    /**
     7. Import User
     - Export all Field
     - Tạo account đăng nhập được luôn, nếu cột password trống thì Pass mặc định: PharmaERP@2023
     **/
    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @HasPermission(PermissionKeyEnum.IMPORT_USER)
    @Operation(summary="Nhập người dùng", description="Nhập tất cả các trường và tạo các tài khoản với mật khẩu mặc định nếu rỗng")
    public Object importUser(@RequestParam("file") MultipartFile file){
        return service.importUser(file);
    }
    
    @PostMapping(value = "/save-list")
    @HasPermission(PermissionKeyEnum.IMPORT_USER)
    @Operation(summary="Lưu danh sách người dùng", description="Lưu danh sách người dùng từ nội dung yêu cầu")
    public Object saveListUser(@RequestBody @Valid UserCreateListDTO dtos){
        return service.saveListUser(dtos);
    }
    
    @GetMapping("/export-template-import")
    @HasPermission(PermissionKeyEnum.IMPORT_USER)
    @Operation(summary="Xuất biểu mẫu nhập", description="Xuất biểu mẫu import người dùng")
    public Object exportTemplate() {
        return ResponseEntity.status(HttpStatus.OK)
                             .headers(FileUtils.genHeadersForExport("template-user-import"))
                             .body(service.exportTemplate());
    }

    /**
     8. Change Password
     - Form truyền lên sẽ có 2 tham số chính: pass mới, nhập lại pass mới
     - Gửi mail thông báo cho user kèm theo password raw mà họ thay đổi
     **/
    @PutMapping("/change-password")
    @HasPermission(PermissionKeyEnum.CHANGE_PASSWORD_USER)
    @Operation(summary="Đổi mật khẩu", description="Đổi mật khẩu với hai tham số: pass mới và nhập lại pass mới")
    public Object changePassword(@RequestBody @Valid UserChangePasswordDTO dto){
        service.changePassword(dto);
        return ResponseEntity.noContent().build();
    }
}
