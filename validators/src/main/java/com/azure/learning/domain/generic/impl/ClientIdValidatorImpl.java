package com.azure.learning.domain.generic.impl;

import com.azure.learning.domain.generic.ClientIdValidator;

import java.util.UUID;

/**
 *
 * @author Ritesh Jaiswal
 *
 */
public class ClientIdValidatorImpl implements ClientIdValidator {


    @Override
    public boolean isValid(String value) {

        if (value != null && value.length() == 36) {

            try {
                UUID uuid = UUID.fromString(value.toString());

                return (uuid.version() == 4) && value.equalsIgnoreCase(uuid.toString());
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return false;
    }
}

