package com.bleedrnge.pi4garage.persistence.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name = "ACCESS_LOG")
public class AccessLog {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Boolean status;

    @Transient
    public static final Boolean STATUS_OPEN = true;
    @Transient
    public static final Boolean STATUS_CLOSED = false;

    @NotNull
    private Instant time;

    @NotNull
    private String ipAddress;

    public AccessLog(){
        super();
        this.time = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
