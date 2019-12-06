package com.azure.learning.domain;

import com.microsoft.azure.storage.table.TableServiceEntity;

import java.io.Serializable;

public class Device extends TableServiceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subjectid;
    private String clientid;
    private String session;
    private String uuid;
    private String name;
    private String description;
    private String entitlementexpiry;
    private String tokenexpiry;
    private String entitlements;
    private String secret;
    private String status;
    private String lastlogondate;
    private String firstdct;
    private String lastdct;

    public Device(){}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
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

    public void setName(String name) { this.name = name;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntitlementexpiry() {
        return entitlementexpiry;
    }

    public void setEntitlementexpiry(String entitlementexpiry) {
        this.entitlementexpiry = entitlementexpiry;
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

    public String getLastLogondate() {
        return lastlogondate;
    }

    public void setLastLogondate(String lastLogondate) {
        this.lastlogondate = lastLogondate;
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
