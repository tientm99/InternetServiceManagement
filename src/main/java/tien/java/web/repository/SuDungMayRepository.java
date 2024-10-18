/**
 * 
 */
package tien.java.web.repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tien.java.web.entity.SuDungMay;

/**
 * 
 */
@Repository
public class SuDungMayRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void insertDangKySDMay(SuDungMay suDungMay) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(suDungMay);
	}
}
