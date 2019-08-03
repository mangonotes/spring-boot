package org.sony.jpa.demo.dao.enitty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_TICKETS")
public class TbTickets implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "DESTINATION")
    private String destination;
    @Column(name = "TICKET_PRICE")
    private Double ticketPrice;
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TRAVELLER_ID", nullable = false)
    private TbTraveller tbTraveller;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
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

    public TbTraveller getTbTraveller() {
        return tbTraveller;
    }

    public void setTbTraveller(TbTraveller tbTraveller) {
        this.tbTraveller = tbTraveller;
    }
}
