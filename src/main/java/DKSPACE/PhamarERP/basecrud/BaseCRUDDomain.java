package DKSPACE.PhamarERP.basecrud;

public enum BaseCRUDDomain {
	ACTIVITY_LOG("base_crud.domain.activity_log"),
	CONTRACT("base_crud.domain.contract"),
	CONTRACT_TYPE("base_crud.domain.contract_type"),
	CRM_COMPANY("base_crud.domain.crm_company"),
	CRM_CONTACT("base_crud.domain.crm_contact"),
	CRM_LEAD("base_crud.domain.crm_lead"),
	CRM_LEAD_ITEM("base_crud.domain.crm_lead_item"),
	CRM_TAG("base_crud.domain.crm_tag"),
	GEN_DEPARTMENT("base_crud.domain.gen_department"),
	GEN_JOB_TITLE("base_crud.domain.gen_job_title"),
	GEN_OFFICER_LEVEL("base_crud.domain.gen_officer_level"),
	GEN_WORK_LOCATION("base_crud.domain.gen_work_location"),
	USER_ACTIVITY("base_crud.domain.user_activity"),
	USER_CERTIFICATE("base_crud.domain.user_certificate"),
	USER_COURS("base_crud.domain.user_cours")
	;
	
	private final String i18nCode;
	
	BaseCRUDDomain(String i18nCode) {
		
		this.i18nCode = i18nCode;
	}
	
	public String getI18nCode() {
		return i18nCode;
	}
}
