package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.app.utils.HibernateUtils.getSession;
import com.app.entity.Candidate;
import com.app.entity.ProgrammingLang;

public class ProgrammingLangDao {
		
	public String addLanguage(ProgrammingLang obj, Long candId) {
		Session session = getSession().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String msg="Not Added!";
		try {
			Candidate cr = session.get(Candidate.class, candId);
			if(cr!=null)
			{
				cr.addLanguage(obj);
				session.persist(obj);
				msg = "Added!";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		session.close();
		return msg;
	}
	
}
