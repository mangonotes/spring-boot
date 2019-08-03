package org.sony.jpa.demo.dao.repository;

import org.sony.jpa.demo.dao.enitty.TbTraveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface TravellerRepository extends JpaRepository<TbTraveller, Integer> {
    @Query("Select DISTINCT t from TbTraveller t INNER JOIN FETCH t.tbTicketsSet")
    Collection<TbTraveller> findAllTravellerWithJoin();
}
