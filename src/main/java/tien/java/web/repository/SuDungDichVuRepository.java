/**
 * 
 */
package tien.java.web.repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tien.java.web.entity.SuDungDichVu;

/**
 * 
 */
@Repository
public class SuDungDichVuRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void insertSuDungDichVu(SuDungDichVu suDungDichVu) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(suDungDichVu);
	}
}
