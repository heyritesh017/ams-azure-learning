package com.azure.learning.domain.generic.exception;


/**
 *
 * @author Ritesh Jaiswal
 *
 */
public class BadEntitlementException extends RuntimeException {

    public BadEntitlementException() {
    }

    public BadEntitlementException(String message) {
        super(message);
    }
}
