package DKSPACE.PhamarERP.general.service.impl;

import DKSPACE.PhamarERP.general.enums.ObjectField;
import DKSPACE.PhamarERP.general.enums.ObjectType;
import DKSPACE.PhamarERP.general.model.Uploadable;
import DKSPACE.PhamarERP.general.model.UploadableId;
import DKSPACE.PhamarERP.general.repository.UploadableRepository;
import DKSPACE.PhamarERP.general.service.UploadableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UploadableServiceImpl implements UploadableService {
	private final UploadableRepository repository;
	
	@Override
	public Object save(Long genUploadId, ObjectType objectType, ObjectField objectField, Long objectId) {
		final var uploadableId = UploadableId.builder()
		                                     .genUploadId(genUploadId)
		                                     .objectId(objectId)
		                                     .build();
		final var uploadable = Uploadable.builder()
		                                 .genUploadId(genUploadId)
		                                 .objectId(objectId)
		                                 .objectField(objectField)
		                             .objectType(objectType)
		                             .build();
		return repository.save(uploadable);
	}
}