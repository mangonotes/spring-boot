package org.sony.jpa.demo.ui.dto;

import java.io.Serializable;
import java.util.List;

public class TravellerDTO implements Serializable {
    private String name;
    private String nationality;
    private List<TicketDTO> tickets;
    private int id;

    public List<TicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDTO> tickets) {
        this.tickets = tickets;
    }

    public TravellerDTO(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }
    public TravellerDTO()
    {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
