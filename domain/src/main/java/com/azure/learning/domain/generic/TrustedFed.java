package com.azure.learning.domain.generic;


/**
 *
 * @author Ritesh Jaiswal
 *
 */
public class TrustedFed extends AbstractGenericObject {
    private String subjectId;
    private String entitlements;


    public TrustedFed() {
    }

    public TrustedFed(com.azure.learning.domain.internal.SessionIn.Trustedfed trustedfed) {
        if (trustedfed != null) {
            this.subjectId = trustedfed.getSubjectId();
            this.entitlements = trustedfed.getEntitlements();
        }
    }


    /* only considered Trustedfed constructor with com.tomtom.ams.domain.internal.SessionIn.Trustedfed parameter
       as the requirement is only for ams and not dam
    */


    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getEntitlements() {
        return entitlements;
    }

    public void setEntitlements(String entitlements) {
        this.entitlements = entitlements;
    }

    @Override
    public com.azure.learning.domain.internal.SessionIn.Trustedfed translateToAmsType() {
        com.azure.learning.domain.internal.SessionIn.Trustedfed
                trustedfed = getAmsObjectFactory().createSessionInTrustedfed();

        if (entitlements != null && subjectId != null) {
            trustedfed.setSubjectId(subjectId);
            trustedfed.setEntitlements(entitlements);
        }

        return trustedfed;
    }

    @Override
    public com.azure.learning.domain.internal.SessionIn.Trustedfed translateToDamType() {
        return null;
    }
}
