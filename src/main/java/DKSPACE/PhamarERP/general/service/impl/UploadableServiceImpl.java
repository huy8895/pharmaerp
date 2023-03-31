package DKSPACE.PhamarERP.general.service.impl;

import DKSPACE.PhamarERP.general.enums.ObjectField;
import DKSPACE.PhamarERP.general.enums.ObjectType;
import DKSPACE.PhamarERP.general.model.GenUpload;
import DKSPACE.PhamarERP.general.model.Uploadable;
import DKSPACE.PhamarERP.general.model.UploadableId;
import DKSPACE.PhamarERP.general.repository.UploadableRepository;
import DKSPACE.PhamarERP.general.service.UploadableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UploadableServiceImpl implements UploadableService {
	private final UploadableRepository repository;
	
	@Override
	public Object save(Long genUploadId, ObjectType objectType, ObjectField objectField, Long objectId,
	                   GenUpload genUpload) {
		UploadableId id = new UploadableId(genUploadId, objectId);
		final var uploadable = Uploadable.builder()
		                                 .id(id)
		                                 .objectField(objectField.name())
		                                 .objectType(objectType.name())
		                                 .genUpload(genUpload)
		                                 .build();
		return repository.save(uploadable);
	}
	
	@Override
	public Object save(Set<GenUpload> genUploadIds, ObjectType objectType, ObjectField objectField, Long objectId) {
		return genUploadIds.stream().map(genUpload -> this.save(genUpload.getId(), objectType, objectField, objectId,
		                                                          genUpload))
		                   .collect(Collectors.toList());
	}
}