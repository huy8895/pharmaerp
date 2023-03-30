package DKSPACE.PhamarERP.general.enums;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import DKSPACE.PhamarERP.crm.model.CrmContact;
import DKSPACE.PhamarERP.user.model.UserCertificate;

public enum ObjectType {
	CRM_CONTACT(CrmContact.class),
	USER_CERTIFICATE(UserCertificate.class),
	USER(User.class);
	
	private final Class<? extends BaseCRUDEntity> aClass;
	
	ObjectType(Class<? extends BaseCRUDEntity> aClass) {
		
		this.aClass = aClass;
	}
	
	public Class<? extends BaseCRUDEntity> getaClass() {
		return aClass;
	}
}
