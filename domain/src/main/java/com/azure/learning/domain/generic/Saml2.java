package com.azure.learning.domain.generic;



/**
 *
 * @author Ritesh Jaiswal
 *
 */
public class Saml2 extends AbstractGenericObject {

    private EncodedStringType response;
    private EncodedStringType artifact;


    public Saml2() {
    }


    public Saml2(com.azure.learning.domain.internal.SessionIn.Saml2 saml2) {
        if (saml2 != null) {
            this.response = new EncodedStringType(saml2.getArtifact());
            this.artifact = new EncodedStringType(saml2.getResponse());

        }

    }


    public Saml2(com.azure.learning.domain.dam.SessionIn.Saml2 saml2) {
        if (saml2 != null) {
            this.response = new EncodedStringType(saml2.getArtifact());
            this.artifact = new EncodedStringType(saml2.getResponse());

        }

    }


    public EncodedStringType getArtifact() {
        return artifact;
    }

    public void setArtifact(EncodedStringType artifact) {
        this.artifact = artifact;
    }


    public EncodedStringType getResponse() {
        return response;
    }

    public void setResponse(EncodedStringType response) {
        this.response = response;
    }

    @Override
    public com.azure.learning.domain.internal.SessionIn.Saml2 translateToAmsType() {
        com.azure.learning.domain.internal.SessionIn.Saml2 saml2 =
                getAmsObjectFactory().createSessionInSaml2();
        return saml2;

    }

    @Override
    public com.azure.learning.domain.dam.SessionIn.Saml2 translateToDamType() {

        com.azure.learning.domain.dam.SessionIn.Saml2 saml2 =
                getDamObjectFactory().createSessionInSaml2();

        return saml2;
    }
}
