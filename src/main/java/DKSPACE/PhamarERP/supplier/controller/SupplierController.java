package DKSPACE.PhamarERP.supplier.controller;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDController;
import DKSPACE.PhamarERP.i18n.response.ResponseWrapper;
import DKSPACE.PhamarERP.supplier.criteria.SupplierCriteria;
import DKSPACE.PhamarERP.supplier.model.Supplier;
import DKSPACE.PhamarERP.supplier.service.SupplierService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/suppliers")
@ResponseWrapper
@Tag(name = "Supplier", description = "Các API liên quan đến Supplier")
public class SupplierController
		extends AbstractBaseCRUDController<Supplier, SupplierService, SupplierCriteria> {
	
	protected SupplierController(SupplierService service) {
		super(service, Supplier.class);
	}
}