package com.azure.learning.domain.generic;



/**
 *
 * @author Ritesh Jaiswal
 *
 */
public class SessionIn extends AbstractGenericObject {

    public Saml2 saml2;

    public TrustedFed trustedfed;

    public Client client;

    public String version;


    public SessionIn() {
    }

    public SessionIn(com.azure.learning.domain.internal.SessionIn sessionIn) {
        if (sessionIn != null) {
            this.saml2 = new Saml2(sessionIn.getSaml2());
            this.trustedfed = new TrustedFed(sessionIn.getTrustedfed());
            this.client = new Client(sessionIn.getClient());
            this.version = sessionIn.getVersion();

        }
    }

    public SessionIn(com.azure.learning.domain.dam.SessionIn sessionIn) {
        if (sessionIn != null) {
            this.saml2 = new Saml2(sessionIn.getSaml2());
            this.client = new Client(sessionIn.getClient());
            this.version = sessionIn.getVersion();
            //trustedfed not considered here as it is only meant for AMS and not DAM

        }

    }


    @Override
    public com.azure.learning.domain.internal.SessionIn translateToAmsType() {
        com.azure.learning.domain.internal.SessionIn
                sessionIn = getAmsObjectFactory().createSessionIn();

        sessionIn.setVersion(version);
        if (saml2 != null) {
            sessionIn.setSaml2(saml2.translateToAmsType());
        }

        if (client != null) {
            sessionIn.setClient(client.translateToAmsType());
        }

        if (trustedfed != null) {
            sessionIn.setTrustedfed(trustedfed.translateToAmsType());
        }

        return sessionIn;
    }

    @Override
    public com.azure.learning.domain.dam.SessionIn translateToDamType() {
        com.azure.learning.domain.dam.SessionIn
                sessionIn = getDamObjectFactory().createSessionIn();

        sessionIn.setVersion(version);
        if (saml2 != null) {
            sessionIn.setSaml2(saml2.translateToDamType());
        }

        if (client != null) {
            sessionIn.setClient(client.translateToDamType());
        }

        return sessionIn;
    }
}
