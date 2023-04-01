package DKSPACE.PhamarERP.general.service;

import DKSPACE.PhamarERP.general.enums.ObjectField;
import DKSPACE.PhamarERP.general.enums.ObjectType;
import DKSPACE.PhamarERP.general.model.GenUpload;

import java.util.Set;

public interface UploadableService {
	Object save(Long genUploadId, ObjectType objectType, ObjectField objectField, Long objectId, GenUpload genUpload);
	
	Object save(Set<GenUpload> genUploadId, ObjectType objectType, ObjectField objectField, Long objectId);
}