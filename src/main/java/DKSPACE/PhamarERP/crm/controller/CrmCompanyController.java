package DKSPACE.PhamarERP.crm.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.crm.criteria.CrmCompanyCriteria;
import DKSPACE.PhamarERP.crm.model.CrmCompany;
import DKSPACE.PhamarERP.crm.service.CrmCompanyService;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/crm-companies")
@ResponseWrapper
@Tag(name = "CrmCompany", description = "Công ty trong hệ thống CRM")
public class CrmCompanyController extends AbstractBaseCRUDController<CrmCompany, CrmCompanyService, CrmCompanyCriteria> {
	protected CrmCompanyController(CrmCompanyService service) {
		super(service, CrmCompany.class);
	}
}
