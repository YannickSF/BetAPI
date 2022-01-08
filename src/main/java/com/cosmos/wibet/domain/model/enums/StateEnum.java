package com.cosmos.wibet.domain.model.enums;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum StateEnum {

    A_VENIR("A_VENIR"), EN_COUR("EN_COUR"), CLOT("CLOT"), TERMINE("TERMINE");

    private String code;

    StateEnum(String code){
        this.code = code;
    }

    public static StateEnum fromCode(String code){
        switch (code){
            case "A_VENIR":
                return A_VENIR;

            case "EN_COUR":
                return EN_COUR;

            case "CLOT":
                return CLOT;

            case "TERMINE":
                return TERMINE;

            default:
                return null;
        }
    }
}
