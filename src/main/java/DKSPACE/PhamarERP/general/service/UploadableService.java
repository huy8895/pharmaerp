package DKSPACE.PhamarERP.general.service;

import DKSPACE.PhamarERP.general.enums.ObjectField;
import DKSPACE.PhamarERP.general.enums.ObjectType;

public interface UploadableService {
	Object save(Long genUploadId, ObjectType objectType, ObjectField objectField, Long objectId);
}