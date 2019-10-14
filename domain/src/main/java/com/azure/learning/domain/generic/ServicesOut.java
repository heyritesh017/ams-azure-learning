package com.azure.learning.domain.generic;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ServicesOut extends AbstractGenericObject {

    public String version;

    public ArrayList<Service> services = new ArrayList<Service>();

    private static final Logger logger = Logger.getLogger(com.azure.learning.domain.internal.ServicesOut.class.getName());


    public ServicesOut() {
    }

    public ServicesOut(com.azure.learning.domain.internal.ServicesOut servicesOut) {
        if (servicesOut != null) {
            this.version = servicesOut.getVersion();

        }

        List<com.azure.learning.domain.internal.ServicesOut.Service>
                serviceList = servicesOut.getService();

        if (serviceList != null && serviceList.size() >= 0) {
            for (com.azure.learning.domain.internal.ServicesOut.Service service : serviceList) {
                this.services.add(new Service(service));
            }

        }
    }

    public ServicesOut(com.azure.learning.domain.dam.ServicesOut servicesOut) {

        if (servicesOut != null) {

            this.version = servicesOut.getVersion();
        }

        List<com.azure.learning.domain.dam.ServicesOut.Service> serviceList =
                servicesOut.getService();

        if (serviceList != null && serviceList.size() >= 0) {

            for (com.azure.learning.domain.dam.ServicesOut.Service service : serviceList) {
                this.services.add(new Service());

            }
        }
    }

    @Override
    public com.azure.learning.domain.internal.ServicesOut translateToAmsType() {
        com.azure.learning.domain.internal.ServicesOut servicesOut = getAmsObjectFactory().createServicesOut();
            servicesOut.setVersion(version);

        for (Service service : services) {
            servicesOut.getService().add(service.translateToAmsType());
        }

        return servicesOut;
    }

    @Override
    public com.azure.learning.domain.dam.ServicesOut translateToDamType() {
        com.azure.learning.domain.dam.ServicesOut
                servicesOut = getDamObjectFactory().createServicesOut();

        servicesOut.setVersion(version);

        for (Service service : services) {
            servicesOut.getService().add(service.translateToDamType());
        }

        return servicesOut;
    }
}
