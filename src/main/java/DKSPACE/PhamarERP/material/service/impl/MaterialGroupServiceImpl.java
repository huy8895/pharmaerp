package DKSPACE.PhamarERP.material.service.impl;

import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import DKSPACE.PhamarERP.material.model.MaterialGroup;
import DKSPACE.PhamarERP.material.repository.MaterialGroupRepository;
import DKSPACE.PhamarERP.material.service.MaterialGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MaterialGroupServiceImpl extends AbstractBaseCRUDService<MaterialGroup, MaterialGroupRepository> implements MaterialGroupService {
	protected MaterialGroupServiceImpl(MaterialGroupRepository repository) {
		super(repository);
	}
}