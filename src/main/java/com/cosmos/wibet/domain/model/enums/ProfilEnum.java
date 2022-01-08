package com.cosmos.wibet.domain.model.enums;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum ProfilEnum {
    DEFAULT("DEFAULT"), CLASSIC("CLASSIC"), ADMIN("ADMIN");

    private String code;

    ProfilEnum(String code){
        this.code = code;
    };

    public static ProfilEnum fromCode(String code){
        switch (code){
            case "DEFAULT":
                return DEFAULT;

            case "CLASSIC":
                return CLASSIC;

            case "ADMIN":
                return ADMIN;

            default:
                return null;
        }
    }
}
