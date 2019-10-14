package com.azure.learning.domain.generic;


/**
 *
 * @author Ritesh Jaiswal
 *
 */
public class EncodedStringType extends AbstractGenericObject {
    private String value;

    private String encoding;

    public EncodedStringType() {

    }


    public EncodedStringType(com.azure.learning.domain.internal.EncodedStringType encodedStringType) {

        if(encodedStringType!=null){

            this.value= encodedStringType.getValue();
            this.encoding=encodedStringType.getEncoding();
        }

    }


    public EncodedStringType(com.azure.learning.domain.dam.EncodedStringType encodedStringType) {
        if (encodedStringType != null) {
            this.value = encodedStringType.getValue();
            this.encoding = encodedStringType.getEncoding();
        }
    }



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @Override
    public  com.azure.learning.domain.internal.EncodedStringType translateToAmsType() {
        com.azure.learning.domain.internal.EncodedStringType encodedStringType =
                getAmsObjectFactory().createEncodedStringType();

        encodedStringType.setValue(value);
        encodedStringType.setEncoding(encoding);

        return  encodedStringType;

    }

    @Override
    public com.azure.learning.domain.dam.EncodedStringType translateToDamType() {

        com.azure.learning.domain.dam.EncodedStringType
                encodedStringType = getDamObjectFactory().createEncodedStringType();

        encodedStringType.setValue(value);
        encodedStringType.setEncoding(encoding);

        return encodedStringType;

    }
}
