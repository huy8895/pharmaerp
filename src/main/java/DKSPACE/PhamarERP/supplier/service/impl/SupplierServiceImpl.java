package DKSPACE.PhamarERP.supplier.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.supplier.model.Supplier;
import DKSPACE.PhamarERP.supplier.repository.SupplierRepository;
import DKSPACE.PhamarERP.supplier.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SupplierServiceImpl extends AbstractBaseCRUDService<Supplier, SupplierRepository> implements SupplierService {
	protected SupplierServiceImpl(SupplierRepository repository) {
		super(repository);
	}
}