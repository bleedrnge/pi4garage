package com.bleedrnge.pi4garage.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AccessLogDto {

    @NotNull
    private Boolean status;

    @NotNull
    @Pattern(regexp = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", message = "Invalid IP address")
    private String ipAddress;

    public AccessLogDto(){
        super();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}
