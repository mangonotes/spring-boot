package org.sony.jpa.demo.dao.repository;

import java.util.List;
import java.util.Optional;

import org.sony.jpa.demo.dao.enitty.TbCustMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<TbCustMaster, Integer>, CustomerCriteriaRepository {
	@Query("select   new org.sony.jpa.demo.dao.enitty.TbCustMaster(t.id, t.createdBy) FROM #{#entityName} t where t.id = :id") 
	Optional<TbCustMaster> findByIdBySelectedFieldsWithoutProjections(@Param("id") Integer id);
	
	@Query(value="select  t.id as id, t.createdBy as createdBy from #{#entityName} t where t.id = ?1", nativeQuery=false) 
	List<LimtedOnly> findByIdBySelectedFieldsWithProjections(Integer id);
	 List<NameOnly> findAllCustmerByDescending(Integer id);
	interface LimtedOnly {

		String getCreatedBy();

	 	 int getId();
	}
	interface NameOnly {

		 String getUserName();

		 String getFirstName() ;
	}
}
