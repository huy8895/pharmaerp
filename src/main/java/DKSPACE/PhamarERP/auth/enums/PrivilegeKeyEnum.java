package DKSPACE.PhamarERP.auth.enums;

import DKSPACE.PhamarERP.i18n.enums.PrivilegeKeyI18N;

public enum PrivilegeKeyEnum {
    CREATE,
    READ,
    UPDATE,
    DELETE,
    EXPORT,
    IMPORT,
    ;
    private PrivilegeKeyI18N i18NCode;

    public PrivilegeKeyEnum i18n(PrivilegeKeyI18N i18NMessageCode) {
        this.i18NCode = i18NMessageCode;
        return this;
    }

    public PrivilegeKeyI18N i18n() {
        return this.i18NCode;
    }
}

enum Action
{
    FOO,
    BAR;

//    todo
    enum MOVE {
        UP("name"),
        DOWN("name"),
        LEFT("name"),
        RIGHT("name");

        public final String name;
        public final String i18n = "";

        MOVE(String name) {
            this.name = name;
        }
    };
    enum MOVE1 {
        UP("name"),
        DOWN("name"),
        LEFT("name"),
        RIGHT("name");

        public final String name;
        public final String i18n = "";

        MOVE1(String name) {
            this.name = name;
        }
    }
}
