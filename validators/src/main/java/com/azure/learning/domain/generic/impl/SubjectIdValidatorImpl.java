package com.azure.learning.domain.generic.impl;

import com.azure.learning.domain.generic.SubjectIdValidator;
import com.azure.learning.domain.generic.Validator;
import org.apache.commons.lang.StringUtils;

/**
 *
 * Default Implementation of {@link SubjectIdValidator}
 *
 * @author Ritesh Jaiswal
 *
 */
public class SubjectIdValidatorImpl implements Validator {


    public static final int MAX_LENGTH = 100;


    @Override
    public boolean isValid(String value) {

        return (!StringUtils.isEmpty(value) && value.length() <= MAX_LENGTH);
    }
}
