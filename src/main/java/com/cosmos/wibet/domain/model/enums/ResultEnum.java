package com.cosmos.wibet.domain.model.enums;

public enum ResultEnum {

    NONE("NONE"), OK("OK"), KO("KO"), NULL("NULL");

    private String code;

    ResultEnum(String code){
        this.code = code;
    }

    public static ResultEnum fromCode(String code){
        switch (code){
            case "OK":
                return OK;

            case "KO":
                return KO;

            case "NULL":
                return NULL;

            case "NONE":
                return NONE;

            default:
                return null;
        }
    }
}
