package DKSPACE.PhamarERP.basecrud;

import DKSPACE.PhamarERP.master_data.entity.*;
import DKSPACE.PhamarERP.master_data.entity.csm.*;

public enum BaseCRUDDomain {
	ACTIVITY_LOG(ActivityLog.class, "base_crud.domain.activity_log"),
	CONTRACT(Contract.class, "base_crud.domain.contract"),
	CONTRACT_TYPE(ContractType.class, "base_crud.domain.contract_type"),
	CRM_COMPANY(CrmCompany.class, "base_crud.domain.crm_company"),
	CRM_CONTACT(CrmContact.class, "base_crud.domain.crm_contact"),
	CRM_LEAD(CrmLead.class, "base_crud.domain.crm_lead"),
	CRM_LEAD_ITEM(CrmLeadItem.class, "base_crud.domain.crm_lead_item"),
	CRM_TAG(CrmTag.class, "base_crud.domain.crm_tag"),
	GEN_DEPARTMENT(GenDepartment.class, "base_crud.domain.gen_department"),
	GEN_JOB_TITLE(GenJobTitle.class, "base_crud.domain.gen_job_title"),
	GEN_OFFICER_LEVEL(GenOfficerLevel.class,"base_crud.domain.gen_officer_level"),
	GEN_WORK_LOCATION(GenWorkLocation.class,"base_crud.domain.gen_work_location"),
	USER_ACTIVITY(UserActivity.class,"base_crud.domain.user_activity"),
	USER_CERTIFICATE(UserCertificate.class,"base_crud.domain.user_certificate"),
	USER_COURS(UserCours.class,"base_crud.domain.user_cours")
	;
	
	private final String i18nCode;
	private final Class<? extends BaseCRUDEntity> entityClass;
	
	BaseCRUDDomain(Class<? extends BaseCRUDEntity> entityClass, String i18nCode) {
		this.entityClass = entityClass;
		this.i18nCode = i18nCode;
	}
	
	public String getI18nCode() {
		return i18nCode;
	}
	
	public Class<? extends BaseCRUDEntity> getEntityClass() {
		return entityClass;
	}
}
