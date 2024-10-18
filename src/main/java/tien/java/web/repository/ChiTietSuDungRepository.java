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
import tien.java.web.model.ChiTietSuDung;
import tien.java.web.page.PageAble;

/**
 * 
 */
@Repository
public class ChiTietSuDungRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private DichVuRepository dichVuRepository;

	@Transactional
	public List<ChiTietSuDung> chiTietSuDung() {
		Session session = sessionFactory.getCurrentSession();
//		String sql ="select new tien.java.web.model.ChiTietSuDung( kh.maKH, kh.tenKH, m.maMay, m.viTri, m.trangThai, sdm.id.ngayBatDauSD,\r\n"
//				+ "sdm.id.gioBatDauSD, sdm.thoiGianSD, dv.maDV, sddv.id.ngaySD,\r\n"
//				+ "sddv.id.gioSD, sddv.soLuong) from KhachHang kh\r\n"
//				+ "join kh.suDungMay sdm \r\n"
//				+ "join sdm.maMay m\r\n"
//				+ "left join kh.suDungDichVu sddv\r\n"
//				+ "join sddv.maDV dv";
		String sql = "select new tien.java.web.model.ChiTietSuDung( kh.maKH, kh.tenKH, m.maMay, m.viTri, m.trangThai, sdm.id.ngayBatDauSD,\r\n"
				+ "sdm.id.gioBatDauSD, sdm.thoiGianSD, dv.maDV, sddv.id.ngaySD,\r\n"
				+ "sddv.id.gioSD, sddv.soLuong) from May m\r\n" + "right join SuDungMay sdm on m.maMay = sdm.maMay\r\n"
				+ "right join KhachHang kh on sdm.maKH = kh.maKH\r\n"
				+ "left join SuDungDichVu sddv on kh.maKH = sddv.maKH\r\n"
				+ "left join DichVu dv on sddv.maDV = dv.maDV " + "WHERE sddv.maKH IS NOT NULL OR sdm.maKH IS NOT NULL";
		Query<ChiTietSuDung> query = session.createQuery(sql, ChiTietSuDung.class);
		List<ChiTietSuDung> list = query.getResultList();
		for (ChiTietSuDung chiTietSuDung : list) {
			if (chiTietSuDung.getMaDV() != null) {
				DichVu dichVu = dichVuRepository.findById(chiTietSuDung.getMaDV());
				int tongTien = dichVu.getDonGia() * chiTietSuDung.getSoLuong();
				chiTietSuDung.setTongTien(tongTien);
			} else {
				chiTietSuDung.setTongTien(null);
			}
		}
		return list;
	}

	@Transactional
	public List<ChiTietSuDung> getAllChiTietSuDung(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select new tien.java.web.model.ChiTietSuDung( kh.maKH, kh.tenKH, kh.diaChi, m.maMay, m.viTri, m.trangThai, sdm.id.ngayBatDauSD,\r\n"
				+ "sdm.id.gioBatDauSD, sdm.thoiGianSD, dv.maDV, sddv.id.ngaySD,\r\n"
				+ "sddv.id.gioSD, sddv.soLuong) from May m\r\n" + "right join SuDungMay sdm on m.maMay = sdm.maMay\r\n"
				+ "right join KhachHang kh on sdm.maKH = kh.maKH\r\n"
				+ "left join SuDungDichVu sddv on kh.maKH = sddv.maKH\r\n"
				+ "left join DichVu dv on sddv.maDV = dv.maDV " + "WHERE sddv.maKH IS NOT NULL OR sdm.maKH IS NOT NULL";
		Query<ChiTietSuDung> query = session.createQuery(sql, ChiTietSuDung.class);
		query.setFirstResult(pageAble.getOffset()).setMaxResults(pageAble.getSize());
		List<ChiTietSuDung> list = query.getResultList();
		for (ChiTietSuDung chiTietSuDung : list) {
			if (chiTietSuDung.getMaDV() != null) {
				DichVu dichVu = dichVuRepository.findById(chiTietSuDung.getMaDV());
				int tongTien = dichVu.getDonGia() * chiTietSuDung.getSoLuong();
				chiTietSuDung.setTongTien(tongTien);
			} else {
				chiTietSuDung.setTongTien(null);
			}
		}
		return list;
	}

	@Transactional
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select COUNT(*) from May m\r\n" + "right join SuDungMay sdm on m.maMay = sdm.maMay\r\n"
				+ "right join KhachHang kh on sdm.maKH = kh.maKH\r\n"
				+ "left join SuDungDichVu sddv on kh.maKH = sddv.maKH\r\n"
				+ "left join DichVu dv on sddv.maDV = dv.maDV " + "WHERE sddv.maKH IS NOT NULL OR sdm.maKH IS NOT NULL";
		return session.createQuery(sql, Long.class).getSingleResult();
	}

	@Transactional
	public List<ChiTietSuDung> searchChiTietSuDung(PageAble pageAble, String tenKH) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select new tien.java.web.model.ChiTietSuDung( kh.maKH, kh.tenKH, kh.diaChi, m.maMay, m.viTri, m.trangThai, sdm.id.ngayBatDauSD,\r\n"
				+ "sdm.id.gioBatDauSD, sdm.thoiGianSD, dv.maDV, sddv.id.ngaySD,\r\n"
				+ "sddv.id.gioSD, sddv.soLuong) "
				+ "from May m\r\n" 
				+ "right join SuDungMay sdm on m.maMay = sdm.maMay\r\n"
				+ "right join KhachHang kh on sdm.maKH = kh.maKH\r\n"
				+ "left join SuDungDichVu sddv on kh.maKH = sddv.maKH\r\n"
				+ "left join DichVu dv on sddv.maDV = dv.maDV " 
				+ "WHERE (sddv.maKH IS NOT NULL OR sdm.maKH IS NOT NULL) "
				+ "AND kh.tenKH LIKE :tenKH";
		Query<ChiTietSuDung> query = session.createQuery(sql, ChiTietSuDung.class);
		query.setParameter("tenKH", "%" + tenKH + "%");
		query.setFirstResult(pageAble.getOffset()).setMaxResults(pageAble.getSize());
		List<ChiTietSuDung> list = query.getResultList();
		for (ChiTietSuDung chiTietSuDung : list) {
			if (chiTietSuDung.getMaDV() != null) {
				DichVu dichVu = dichVuRepository.findById(chiTietSuDung.getMaDV());
				int tongTien = dichVu.getDonGia() * chiTietSuDung.getSoLuong();
				chiTietSuDung.setTongTien(tongTien);
			} else {
				chiTietSuDung.setTongTien(null);
			}
		}
		return list;
	}

	@Transactional
	public long countSearch(String tenKH) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select COUNT(*) from May m\r\n" + "right join SuDungMay sdm on m.maMay = sdm.maMay\r\n"
				+ "right join KhachHang kh on sdm.maKH = kh.maKH\r\n"
				+ "left join SuDungDichVu sddv on kh.maKH = sddv.maKH\r\n"
				+ "left join DichVu dv on sddv.maDV = dv.maDV " + "WHERE(sddv.maKH IS NOT NULL OR sdm.maKH IS NOT NULL) "
				+ "AND kh.tenKH LIKE :tenKH";
		return session.createQuery(sql, Long.class).setParameter("tenKH", "%" + tenKH + "%").getSingleResult();
	}
}
