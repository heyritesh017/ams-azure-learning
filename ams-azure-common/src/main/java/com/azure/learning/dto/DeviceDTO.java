package com.azure.learning.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceDTO {

    private String clientid;
    private String subjectid;
    private String uuid;
    private String name;
    private String description;
    private String tokenexpiry;
    private String entitlements;
    private String secret;
    private String status;
    private String lastlogonDate;
    private String firstdct;
    private String lastdct;

    public DeviceDTO(){}

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTokenexpiry() {
        return tokenexpiry;
    }

    public void setTokenexpiry(String tokenexpiry) {
        this.tokenexpiry = tokenexpiry;
    }

    public String getEntitlements() {
        return entitlements;
    }

    public void setEntitlements(String entitlements) {
        this.entitlements = entitlements;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastlogonDate() {
        return lastlogonDate;
    }

    public void setLastlogonDate(String lastlogonDate) {
        this.lastlogonDate = lastlogonDate;
    }

    public String getFirstdct() {
        return firstdct;
    }

    public void setFirstdct(String firstdct) {
        this.firstdct = firstdct;
    }

    public String getLastdct() {
        return lastdct;
    }

    public void setLastdct(String lastdct) {
        this.lastdct = lastdct;
    }

}
