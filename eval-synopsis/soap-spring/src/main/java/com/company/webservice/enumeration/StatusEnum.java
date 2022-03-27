package com.company.webservice.enumeration;

import com.company.webservice.wsdl.StatusWs;
import lombok.Getter;

@Getter
public enum StatusEnum {

    OK("0000", "Proceso exitoso.");

    private final StatusWs status;

    StatusEnum(String code, String message){
        status = new StatusWs();
        this.status.setCode(code);
        this.status.setMessage(message);
    }

}
