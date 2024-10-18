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
import tien.java.web.page.PageAble;

/**
 * 
 */
@Repository
public class KhachHangRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void insertKH(KhachHang khachHang) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(khachHang);
	}

	@Transactional
	public KhachHang findById(String maKH) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(KhachHang.class, maKH);
	}

	@Transactional
	public KhachHang getKhachHangByMaKH(String maKH) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(KhachHang.class, maKH);
	}

	@Transactional
	public List<KhachHang> getAllKhachHang() {
		Session session = sessionFactory.getCurrentSession();
		Query<KhachHang> query = session.createQuery("From KhachHang", KhachHang.class);
		return query.getResultList();
	}

	@Transactional
	public List<KhachHang> getAllKhachHangWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<KhachHang> khachHangs = session.createQuery("From KhachHang", KhachHang.class)
				.setFirstResult(pageAble.getOffset()).setMaxResults(pageAble.getSize()).getResultList();
		return khachHangs;
	}

	@Transactional
	public void deleteKhachHang(KhachHang khachHang) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(khachHang);
	}

	@Transactional
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("Select COUNT(*) from KhachHang m", Long.class).getSingleResult();
	}

	@Transactional
	public boolean khachHangExist(String maKH) {
		Session session = sessionFactory.getCurrentSession();
		if (session.get(KhachHang.class, maKH) == null) {
			return true;
		}
		return false;
	}

	@Transactional
	public List<KhachHang> searchKhachHang(PageAble pageAble, String tenKH) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From KhachHang Where tenKH Like :tenKH or diaChi Like :tenKH";
		Query<KhachHang> query = session.createQuery(hql, KhachHang.class);
		query.setParameter("tenKH", "%" + tenKH + "%");
		query.setFirstResult(pageAble.getOffset());
		query.setMaxResults(pageAble.getSize());
		List<KhachHang> list = query.getResultList();
		return list;
	}
	
	@Transactional
	public long countsearch(String tenKH) {
		Session session = sessionFactory.getCurrentSession();
		Query<Long> query = session.createQuery("Select COUNT(*) from KhachHang Where tenKH Like :tenKH or diaChi Like :tenKH", Long.class);
		query.setParameter("tenKH", "%" + tenKH + "%");
		return query.getSingleResult();
	}
}
