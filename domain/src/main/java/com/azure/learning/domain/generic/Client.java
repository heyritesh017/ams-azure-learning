package com.azure.learning.domain.generic;


import com.azure.learning.domain.dam.SessionIn;

/**
 *
 * Contains data consumer type information
 *
 * @author Ritesh Jaiswal
 *
 */
public class Client extends  AbstractGenericObject {

    private String clientType ;


    Client(){

    }

    Client(com.azure.learning.domain.internal.SessionIn.Client client){
        if (client != null) {
            this.clientType = client.getClientType();
        }

    }

    Client(com.azure.learning.domain.dam.SessionIn.Client client){
        if (client != null) {
            this.clientType = client.getClientType();
        }

    }



    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    @Override
    public com.azure.learning.domain.internal.SessionIn.Client translateToAmsType() {
        com.azure.learning.domain.internal.SessionIn.Client
                client = getAmsObjectFactory().createSessionInClient();

        client.setClientType(clientType);
        return client;
    }

    @Override
    public com.azure.learning.domain.dam.SessionIn.Client translateToDamType() {
        com.azure.learning.domain.dam.SessionIn.Client
                client = getDamObjectFactory().createSessionInClient();

        client.setClientType(clientType);
        return client;
    }
}
