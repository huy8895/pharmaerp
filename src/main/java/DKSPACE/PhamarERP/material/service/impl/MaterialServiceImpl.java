package DKSPACE.PhamarERP.material.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.material.model.Material;
import DKSPACE.PhamarERP.material.repository.MaterialRepository;
import DKSPACE.PhamarERP.material.service.MaterialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MaterialServiceImpl extends AbstractBaseCRUDService<Material, MaterialRepository> implements MaterialService {
	protected MaterialServiceImpl(MaterialRepository repository) {
		super(repository);
	}
}