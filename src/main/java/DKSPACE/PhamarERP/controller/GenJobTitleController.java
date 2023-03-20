package DKSPACE.PhamarERP.controller;

import DKSPACE.PhamarERP.auth.aop.HasPermission;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionKeyEnum;
import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.dto.criteria.GenJobTitleCriteria;
import DKSPACE.PhamarERP.master_data.entity.GenJobTitle;
import DKSPACE.PhamarERP.service.GenJobTitleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/gen-job-titles")
@ResponseWrapper
@Tag(name = "GenJobTitle", description = "Các API liên quan đến GenJobTitle")
public class GenJobTitleController extends AbstractBaseCRUDController<GenJobTitle, GenJobTitleService, GenJobTitleCriteria> {
	protected GenJobTitleController(GenJobTitleService service) {
		super(service, GenJobTitle.class);
	}
	
	@Override
	@HasPermission(PermissionKeyEnum.CREATE_JOB_TITLE)
	public Object create(GenJobTitle entity) {
		return super.create(entity);
	}
	
	@Override
	@HasPermission(PermissionKeyEnum.IMPORT_JOB_TITLE)
	public Object saveList(List<GenJobTitle> entity) {
		return super.saveList(entity);
	}
	
	@Override
	@HasPermission(PermissionKeyEnum.DETAIL_JOB_TITLE)
	public Object getDetail(Long id) {
		return super.getDetail(id);
	}
	
	@Override
	@HasPermission(PermissionKeyEnum.LIST_JOB_TITLE)
	public Object getListByCriteria(Pageable pageable, GenJobTitleCriteria criteria) {
		return super.getListByCriteria(pageable, criteria);
	}
	
	@Override
	@HasPermission(PermissionKeyEnum.UPDATE_JOB_TITLE)
	public Object update(GenJobTitle entity) {
		return super.update(entity);
	}
	
	@Override
	@HasPermission(PermissionKeyEnum.DELETE_JOB_TITLE)
	public ResponseEntity<Void> delete(Long id) {
		return super.delete(id);
	}
	
	@Override
	@HasPermission(PermissionKeyEnum.IMPORT_JOB_TITLE)
	public ResponseEntity<byte[]> exportTemplate() {
		return super.exportTemplate();
	}
	
	@Override
	@HasPermission(PermissionKeyEnum.EXPORT_JOB_TITLE)
	public Object exportFileExcel(MultipartFile file) {
		return super.exportFileExcel(file);
	}
	
	@Override
	@HasPermission(PermissionKeyEnum.IMPORT_JOB_TITLE)
	public ResponseEntity<byte[]> importFileExcel() {
		return super.importFileExcel();
	}
}
