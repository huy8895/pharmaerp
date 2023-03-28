package DKSPACE.PhamarERP.supplier.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.supplier.model.SupplierContact;
import DKSPACE.PhamarERP.supplier.repository.SupplierContactRepository;
import DKSPACE.PhamarERP.supplier.service.SupplierContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SupplierContactServiceImpl extends AbstractBaseCRUDService<SupplierContact, SupplierContactRepository> implements SupplierContactService {
	protected SupplierContactServiceImpl(SupplierContactRepository repository) {
		super(repository);
	}
}