package org.sony.jpa.demo.dao.enitty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Embeddable
public class CorporateIdentityKey  implements Serializable {
    @NotNull
    private int corporateId;
    @NotNull
    private String corporateName;

    public int getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(int corporateId) {
        this.corporateId = corporateId;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public CorporateIdentityKey(@NotNull int corporateId, @NotNull String corporateName) {
        this.corporateId = corporateId;
        this.corporateName = corporateName;
    }

    @Override
    public int hashCode() {
       return new HashCodeBuilder().append(corporateId).append(corporateName).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CorporateIdentityKey){
            final CorporateIdentityKey other = (CorporateIdentityKey) obj;
            return new EqualsBuilder()
                    .append(corporateName, other.corporateName)
                    .append(corporateId, other.corporateId)
                    .isEquals();
        } else{
            return false;
        }

    }

    public CorporateIdentityKey() {
    }

}
