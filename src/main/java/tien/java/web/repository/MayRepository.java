/**
 * 
 */
package tien.java.web.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tien.java.web.entity.KhachHang;
import tien.java.web.entity.May;
import tien.java.web.entity.SuDungMay;
import tien.java.web.page.PageAble;

/**
 * 
 */
@Repository
public class MayRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void insertMay(May may) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(may);
	}
	
	@Transactional
	public May findById(String maMay) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(May.class, maMay);
	}
	
	@Transactional
	public List<May> getAllMay() {
		Session session = sessionFactory.getCurrentSession();
		Query<May> query = session.createQuery("From May", May.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<May> getAllMayWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<May> mays = session.createQuery("From May", May.class)
				.setFirstResult(pageAble.getOffset())
				.setMaxResults(pageAble.getSize()).getResultList();
		return mays;
	}
	
	@Transactional
	public void deleteMay(May may) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(may);
	}
	
	@Transactional
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("Select COUNT(*) from May m",Long.class).getSingleResult();
	}
	
	@Transactional
	public boolean mayExist(String maMay) {
		Session session = sessionFactory.getCurrentSession();
		if(session.get(May.class, maMay) == null) {
			return true;
		}
		return false;
	}
}
