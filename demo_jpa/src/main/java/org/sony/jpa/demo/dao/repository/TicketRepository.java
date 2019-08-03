package org.sony.jpa.demo.dao.repository;

import org.sony.jpa.demo.dao.enitty.TbTickets;
import org.sony.jpa.demo.dao.enitty.TbTraveller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TbTickets, Integer> {
}
