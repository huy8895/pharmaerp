package DKSPACE.PhamarERP.general.service;

import DKSPACE.PhamarERP.general.enums.ObjectField;
import DKSPACE.PhamarERP.general.enums.ObjectType;

import java.util.Set;

public interface UploadableService {
	Object save(Long genUploadId, ObjectType objectType, ObjectField objectField, Long objectId);
	
	Object save(Set<Long> genUploadId, ObjectType objectType, ObjectField objectField, Long objectId);
}