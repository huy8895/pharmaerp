package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.master_data.dto.user.UserChangePasswordDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserCreateDTO;
import DKSPACE.PhamarERP.master_data.dto.user.UserUpdateDTO;
import DKSPACE.PhamarERP.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
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
    public Object listUser(){
        return service.listUser();
    }

    /**
     * 2. Tạo mới user
     - Tạo mới toàn bộ các thông tin
     - Password mặc định PharmaERP@2023 -> tạo 1 const lưu cái này
     **/
    @PostMapping
    public Object createUser(@RequestBody @Valid UserCreateDTO dto){
        return service.createUser(dto);
    }

    /**
     3. Sửa thông tin user
     - Update các thông tin khác ngoại trừ password và is_active vì đã có chức năng riêng
     **/
    @PutMapping
    public Object updateUser(@RequestBody @Valid UserUpdateDTO dto){
        return service.updateUser(dto);
    }


    /**
     4. Active/Deactive User
     - Đơn giản user truyền lên j thì lưu đó.
     **/
    @PutMapping("/toggle-active/{id}")
    public Object toggleActiveUser(@PathVariable Long id){
        return service.toggleActiveUser(id);
    }

    /**
     5. Add role cho User
     - Thêm 1 or nhiều role cho  User
     **/
    @PutMapping("/add-roles/{userId}")
    public Object addRoles(@PathVariable("userId") Long userId, @RequestBody List<Long> rolesId){
        return service.addRoles(userId, rolesId);
    }

    /**
     6. Export User
     - Export all Field ngoại trừ password
     **/
    @GetMapping("/export-user")
    public Object exportUser(){
        return service.exportUser();
    }

    /**
     7. Import User
     - Export all Field
     - Tạo account đăng nhập được luôn, nếu cột password trống thì Pass mặc định: PharmaERP@2023
     **/
    @GetMapping("/import-user")
    public Object importUser(){
        return service.importUser();
    }

    /**
     8. Change Password
     - Form truyền lên sẽ có 2 tham số chính: pass mới, nhập lại pass mới
     - Gửi mail thông báo cho user kèm theo password raw mà họ thay đổi
     **/
    @GetMapping("/change-password")
    public Object changePassword(@RequestBody @Valid UserChangePasswordDTO dto){
        return service.changePassword(dto);
    }
}
