package DKSPACE.PhamarERP.controller.csm;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.master_data.entity.csm.CrmTag;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/crm-tags")
@ResponseWrapper(excludes = {"exportTemplate", "exportFileExcel"})
@Tag(name = "Tag", description = "Các API liên quan đến Nhãn")
public class CrmTagController extends AbstractBaseCRUDController<CrmTag, CrmTagService, CrmTagCriteria> {
	protected CrmTagController(CrmTagService service) {
		super(service, CrmTag.class);
	}
}
