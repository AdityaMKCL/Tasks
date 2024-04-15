package com.app.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Candidate;

import static com.app.utils.HibernateUtils.getSession;

import java.util.List;

public class CandidateDao {
	
	public boolean addCandidate(Candidate can) {
		boolean flag=false;
		
		Session session = getSession().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.persist(can);
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null)tx.rollback();
			throw e;
		}
		
		
		session.close();
		return flag;
	}
	
	@SuppressWarnings("deprecation")
	public Long getCandidateId(Candidate can ) {
		Long flag=-1L;
		
		Session session = getSession().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "FROM " + Candidate.class.getName() + " can WHERE can.user_name = :uname";
			Query query = session.createQuery(hql);
			query.setParameter("uname",  can.getUser_name()); 
			List<Candidate> candi= query.list();
			flag=candi.get(0).getId();
		}catch(Exception e){
			System.out.println(e);
		}
		session.close();
		return flag;
	}
	
}
