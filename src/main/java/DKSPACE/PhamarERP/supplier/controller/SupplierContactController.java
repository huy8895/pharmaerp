package DKSPACE.PhamarERP.supplier.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.supplier.criteria.SupplierContactCriteria;
import DKSPACE.PhamarERP.supplier.model.SupplierContact;
import DKSPACE.PhamarERP.supplier.service.SupplierContactService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/supplier-contacts")
@ResponseWrapper
@Tag(name = "SupplierContact", description = "Các API liên quan đến SupplierContact")
public class SupplierContactController
		extends AbstractBaseCRUDController<SupplierContact, SupplierContactService, SupplierContactCriteria> {
	
	protected SupplierContactController(SupplierContactService service) {
		super(service, SupplierContact.class);
	}
}