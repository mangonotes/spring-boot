package com.example.fluxjpa.dao.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Table(name="TB_EVENTS")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="EVENT_NAME")
    private String eventName;
    @Column (name="EVENT_DESCRIPTION")
    private String eventDescription;
    @Column(name="CREATED_BY")
    private String createdBy;
    @Column(name="CREATED_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDt;
    @Column(name="MODIFIED_BY")
    private String modifiedBy;
    @Column(name="MODIFIED_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
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
