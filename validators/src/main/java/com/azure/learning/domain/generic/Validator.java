package com.azure.learning.domain.generic;


/**
 *
 * @author Ritesh Jaiswal
 *
 */
public interface Validator  {


    /**
     * Validates String value
     *
     * @param value
     *
     * @return <code>true</code> if value is valid and <code>false</code> if not
     */
    boolean isValid(String value);
}
