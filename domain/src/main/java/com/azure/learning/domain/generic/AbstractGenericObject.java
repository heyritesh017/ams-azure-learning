package com.azure.learning.domain.generic;


import com.azure.learning.domain.dam.ObjectFactory;

/**
 * Abstract Domain Object
 *
 * @author Ritesh Jaiswal
 */
public abstract class AbstractGenericObject {

    private com.azure.learning.domain.internal.ObjectFactory amsObjectFactory = new com.azure.learning.domain.internal.ObjectFactory();

    private com.azure.learning.domain.dam.ObjectFactory damObjectFactory = new com.azure.learning.domain.dam.ObjectFactory();


    /**
     * AMS Object factory getter
     *
     * @return AMS Object Factory
     */
    protected com.azure.learning.domain.internal.ObjectFactory getAmsObjectFactory() {

        return amsObjectFactory;

    }

    ;

    /**
     * DAM Object factory getter
     *
     * @return DAM Object Factory
     */
    protected com.azure.learning.domain.dam.ObjectFactory getDamObjectFactory() {

        return damObjectFactory;
    }


    /**
     * Translates object to the type of AMS
     *
     * @return AMS-domain object
     */
    public abstract Object translateToAmsType();


    /**
     * Translates object to the type of AMS
     *
     * @return DAM-domain object
     */
    public abstract Object translateToDamType();

}


