package DKSPACE.PhamarERP.basecrud;

public enum BaseCRUDAction {
	CREATE("base_crud.action.create"),
	DETAIL("base_crud.action.detail"),
	UPDATE("base_crud.action.update"),
	DELETE("base_crud.action.delete"),
	LIST("base_crud.action.list"),
	IMPORT("base_crud.action.import"),
	EXPORT("base_crud.action.export"),
	;
	
	private final String i18nCode;
	
	BaseCRUDAction(String i18nCode) {
		
		this.i18nCode = i18nCode;
	}
	
	public String getI18nCode() {
		return i18nCode;
	}
}
