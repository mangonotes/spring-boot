package org.sony.jpa.demo.dao.enitty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "TB_TRAVELLER")
public class TbTraveller implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int travellerId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDt;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDt;
    @OneToMany(mappedBy = "tbTraveller", cascade = CascadeType.ALL)
    private Set<TbTickets> tbTicketsSet;

    public Set<TbTickets> getTbTicketsSet() {
        return tbTicketsSet;
    }

    public void setTbTicketsSet(Set<TbTickets> tbTicketsSet) {
        this.tbTicketsSet = tbTicketsSet;
    }

    @PrePersist
    public void addCreatedDt()
    {
        createdDt = new Date();
    }
    @PreUpdate
    public void updateModifiedDate()
    {
        modifiedDt = new Date();
    }

    public int getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(int travellerId) {
        this.travellerId = travellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDt() {
        return modifiedDt;
    }

    public void setModifiedDt(Date modifiedDt) {
        this.modifiedDt = modifiedDt;
    }
}
