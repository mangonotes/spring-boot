package org.sony.jpa.demo.ui.dto;

import java.io.Serializable;

public class CorporateCustomerDTO implements Serializable {
    private String corporateName;
    private int corporateId;
    private String address;
    private int totalValue;

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public int getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(int corporateId) {
        this.corporateId = corporateId;
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
