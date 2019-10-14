package com.azure.learning.domain.generic;

public class SessionOut extends AbstractGenericObject {

    private String version;

    private String clientId;

    private ServicesOut servicesOut;

    public SessionOut() {
    }


    public SessionOut(com.azure.learning.domain.internal.SessionOut sessionOut) {
        if (sessionOut != null) {

            this.version = sessionOut.getVersion();

            com.azure.learning.domain.internal.SessionOut.ClientId
                    clientId = sessionOut.getClientId();

            com.azure.learning.domain.internal.ServicesOut
                    servicesOut = sessionOut.getServicesOut();

            if (clientId != null) {
                this.clientId = clientId.getValue();
            }

            if (servicesOut != null) {
                this.servicesOut = new ServicesOut(servicesOut);
            }

        }


    }


    public SessionOut(com.azure.learning.domain.dam.SessionOut sessionOut) {
        if (sessionOut != null) {
            this.version = sessionOut.getVersion();

            com.azure.learning.domain.dam.SessionOut.ClientId
                    clientId = sessionOut.getClientId();

            com.azure.learning.domain.dam.ServicesOut
                    servicesOut = sessionOut.getServicesOut();

            if (clientId != null) {
                this.clientId = clientId.getValue();
            }

            if (servicesOut != null) {
                this.servicesOut = new ServicesOut(servicesOut);
            }
        }
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public ServicesOut getServicesOut() {
        return servicesOut;
    }

    public void setServicesOut(ServicesOut servicesOut) {
        this.servicesOut = servicesOut;
    }

    @Override
    public com.azure.learning.domain.internal.SessionOut translateToAmsType() {
        com.azure.learning.domain.internal.SessionOut
                sessionOut = getAmsObjectFactory().createSessionOut();

        com.azure.learning.domain.internal.SessionOut.ClientId
                clientId = getAmsObjectFactory().createSessionOutClientId();

        clientId.setValue(this.clientId);

        sessionOut.setVersion(version);
        sessionOut.setClientId(clientId);
        sessionOut.setServicesOut(servicesOut.translateToAmsType());

        return sessionOut;
    }

    @Override
    public com.azure.learning.domain.dam.SessionOut translateToDamType() {
        com.azure.learning.domain.dam.SessionOut
                sessionOut = getDamObjectFactory().createSessionOut();


        com.azure.learning.domain.dam.SessionOut.ClientId
                clientId = getDamObjectFactory().createSessionOutClientId();

        clientId.setValue(this.clientId);

        sessionOut.setClientId(clientId);
        sessionOut.setServicesOut(servicesOut.translateToDamType());
        sessionOut.setVersion(version);

        return sessionOut;


    }
}
