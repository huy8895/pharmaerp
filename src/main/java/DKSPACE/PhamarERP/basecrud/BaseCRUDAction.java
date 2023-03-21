package DKSPACE.PhamarERP.basecrud;

import DKSPACE.PhamarERP.auth.enums.permission.HasI18NCode;
import DKSPACE.PhamarERP.auth.enums.permission.PermissionGroupEnum;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum BaseCRUDAction implements HasI18NCode {
	CREATE("base_crud.action.create"),
	DETAIL("base_crud.action.detail"),
	UPDATE("base_crud.action.update"),
	DELETE("base_crud.action.delete"),
	LIST("base_crud.action.list"),
	IMPORT("base_crud.action.import"),
	EXPORT("base_crud.action.export"),
	;
	static {
		MAP = Arrays.stream(values()).collect(Collectors.toMap(Enum::name, p -> p));
	}
	
	private static final Map<String, BaseCRUDAction> MAP;
	
	private final String i18nCode;
	
	BaseCRUDAction(String i18nCode) {
		
		this.i18nCode = i18nCode;
	}
	
	public String getI18nCode() {
		return i18nCode;
	}
	
	public static BaseCRUDAction from(String action) {
		return MAP.get(action);
	}
	
	public String getPermissionKey(PermissionGroupEnum groupEnum){
		if (groupEnum == null || !groupEnum.isBaseCRUD()) return "";
		return this.name().concat("_" + groupEnum.name());
	}
	
	public static BaseCRUDAction resolveKey(String key, PermissionGroupEnum group){
		if (key == null) return null;
		final var action = key.replace("_" + group.name(), "");
		return from(action);
	}
	
	public static String getKeyNameI18N(PermissionGroupEnum groupEnum, BaseCRUDAction action,
	                                    Function<HasI18NCode, String> function){
		if (groupEnum == null || !groupEnum.isBaseCRUD()) return "";
		final var groupName = function.apply(groupEnum);
		final var actionName = function.apply(action);
		return actionName + " " + groupName;
	}
}
