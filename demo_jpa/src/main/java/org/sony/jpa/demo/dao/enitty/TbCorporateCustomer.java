package org.sony.jpa.demo.dao.enitty;

import javax.persistence.*;

@Entity
@Table(name="TB_CORPORATE_CUSTOMER")
public class TbCorporateCustomer{
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride( name = "corporateId", column = @Column(name = "CORPORATE_ID")),
            @AttributeOverride( name = "corporateName", column = @Column(name = "CORPORATE_NAME"))
    })
    private CorporateIdentityKey corporateIdentityKey;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="TOTAL_VALUE")
    private int totalValue;

    public CorporateIdentityKey getCorporateIdentityKey() {
        return corporateIdentityKey;
    }

    public void setCorporateIdentityKey(CorporateIdentityKey corporateIdentityKey) {
        this.corporateIdentityKey = corporateIdentityKey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }
}
