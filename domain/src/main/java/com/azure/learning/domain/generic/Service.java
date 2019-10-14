package com.azure.learning.domain.generic;

/**
 *
 * @author Ritesh Jaiswal
 *
 */
public class Service extends AbstractGenericObject {

    private String id;

    public Service() {
    }


    public Service(com.azure.learning.domain.internal.ServicesOut.Service service) {
        if (service != null) {
            com.azure.learning.domain.internal.ServicesOut.Service.Id
                    id = service.getId();
            if (id != null) {

                this.id = id.getValue();
            }
        }
    }


    public Service(com.azure.learning.domain.dam.ServicesOut.Service service) {

        if (service != null) {
            com.azure.learning.domain.dam.ServicesOut.Service.Id id =
                    service.getId();
            if (id != null) {

                this.id = id.getValue();
            }

        }
    }


    @Override
    public com.azure.learning.domain.internal.ServicesOut.Service translateToAmsType() {
        com.azure.learning.domain.internal.ServicesOut.Service service = getAmsObjectFactory().createServicesOutService();

        com.azure.learning.domain.internal.ServicesOut.Service.Id
                id = getAmsObjectFactory().createServicesOutServiceId();

        id.setValue(this.id);
        service.setId(id);

        return service;
    }

    @Override
    public com.azure.learning.domain.dam.ServicesOut.Service translateToDamType() {
        com.azure.learning.domain.dam.ServicesOut.Service service = getDamObjectFactory().createServicesOutService();

        com.azure.learning.domain.dam.ServicesOut.Service.Id
                id = getDamObjectFactory().createServicesOutServiceId();

        id.setValue(this.id);
        service.setId(id);

        return service;
    }
}
