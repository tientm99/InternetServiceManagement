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

import tien.java.web.entity.DichVu;
import tien.java.web.entity.KhachHang;
import tien.java.web.page.PageAble;

/**
 * 
 */
@Repository
public class DichVuRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void insertDichVu(DichVu dichVu) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(dichVu);
	}
	
	@Transactional
	public DichVu findById(String maDV) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(DichVu.class, maDV);
	}
	
	@Transactional
	public List<DichVu> getAllDichVu() {
		Session session = sessionFactory.getCurrentSession();
		Query<DichVu> query = session.createQuery("From DichVu", DichVu.class);
		return query.getResultList();
	}
	
	@Transactional
	public List<DichVu> getAllDichVuWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<DichVu> dichVus = session.createQuery("From DichVu", DichVu.class)
				.setFirstResult(pageAble.getOffset())
				.setMaxResults(pageAble.getSize()).getResultList();
		return dichVus;
	}
	
	@Transactional
	public void deleteDichVu(DichVu dichVu) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(dichVu);
	}
	
	@Transactional
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("Select COUNT(*) from DichVu d",Long.class).getSingleResult();
	}
	
	@Transactional
	public boolean dichVuExist(String maDV) {
		Session session = sessionFactory.getCurrentSession();
		if(session.get(DichVu.class, maDV) == null) {
			return true;
		}
		return false;
	}
	
	@Transactional
	public List<DichVu> searchDichVu(PageAble pageAble, String tenDV){
		Session session = sessionFactory.getCurrentSession();
		String hql = "From DichVu Where tenDV Like :tenDV";
		Query<DichVu> query = session.createQuery(hql, DichVu.class);
		query.setParameter("tenDV", "%" + tenDV + "%");
		query.setFirstResult(pageAble.getOffset()).setMaxResults(pageAble.getSize());
		List<DichVu> list = query.getResultList();
		return list;
	}
	
	@Transactional
	public long countSearch(String tenDV) {
		Session session = sessionFactory.getCurrentSession();
		Query<Long> query = session.createQuery("Select COUNT(*) from DichVu Where tenDV Like :tenDV",Long.class);
		query.setParameter("tenDV", "%" + tenDV + "%");
		return query.getSingleResult();
	}
}
