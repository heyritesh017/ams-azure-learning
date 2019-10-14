package com.azure.learning.domain.generic.impl;

import com.azure.learning.domain.generic.EntitlementIdValidator;
import com.azure.learning.domain.generic.Validator;
import com.azure.learning.domain.generic.exception.BadEntitlementException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/**
 *  Default Implementation of {@link EntitlementIdValidator}
 *
 * @author Ritesh Jaiswal
 *
 */

public class EntitlementIdValidatorImpl implements Validator {

    private Set<String> validIds = new HashSet<>();

    private static final String ENTITLEMENT_EXPRESSION = "[a-zA-Z]+(\\.[a-zA-Z]+)*(:[a-zA-Z]+(\\.[a-zA-Z]+)*)?";


    public EntitlementIdValidatorImpl(String filename) throws IOException {

        InputStream fileInputStream = this.getClass().getClassLoader().getResourceAsStream(filename);

        if (fileInputStream == null) {
            throw new FileNotFoundException("Cannot load entitlementIds file :" + filename);
        }

        Scanner scanner = new Scanner(fileInputStream);

        Pattern entilementPattern = Pattern.compile(ENTITLEMENT_EXPRESSION);

        while (scanner.hasNext()) {
            String entitlement = scanner.nextLine().trim();

            if (!entitlement.isEmpty()) {
                if (entilementPattern.matcher(entitlement).matches()) {
                    validIds.add(entitlement);
                }

            } else {

                throw new BadEntitlementException("Entitlement is not valid :" + entitlement);
            }

        }


    }

    @Override
    public boolean isValid(String value) {
        return (validIds.contains(value));
    }
}
