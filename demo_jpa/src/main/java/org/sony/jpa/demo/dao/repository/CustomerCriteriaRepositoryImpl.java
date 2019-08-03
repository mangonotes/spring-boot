package org.sony.jpa.demo.dao.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.sony.jpa.demo.dao.enitty.TbCustMaster;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class CustomerCriteriaRepositoryImpl implements CustomerCriteriaRepository {
	@PersistenceContext	
	private EntityManager entityManager;
	@Override
	public Optional<TbCustMaster> findByCustomerCriteria(int id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<TbCustMaster> cq = cb.createQuery(TbCustMaster.class);
	    Root<TbCustMaster> master = cq.from(TbCustMaster.class);
	    cq.multiselect(master.get("id"), master.get("createdBy"));
		cq.where(cb.equal(master.get("id"), id));
	    List<TbCustMaster> results =entityManager.createQuery(cq).getResultList();
	    System.out.println("entry ::" + results.size());
		return  results.stream().findFirst();
	}

}
