/**
 * 
 */
package tien.java.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tien.java.web.entity.KhachHang;
import tien.java.web.model.ChiTietSuDung;
import tien.java.web.page.PageAble;
import tien.java.web.repository.KhachHangRepository;

/**
 * 
 */
@Service
public class KhachHangService {

	@Autowired
	private KhachHangRepository khachHangRepository;
	
	@Transactional
	public void insertKhachHang(KhachHang khachHang) {
		khachHangRepository.insertKH(khachHang);
	}
	
	@Transactional
	public KhachHang findById(String maKH) {
		return khachHangRepository.findById(maKH);
	}
	
	@Transactional
	public KhachHang getKhachHangByMaKH(String maKH) {
		return khachHangRepository.getKhachHangByMaKH(maKH);
	}
	
	@Transactional
	public List<KhachHang> getAllKhachHang() {
		return khachHangRepository.getAllKhachHang();
	}
	
	@Transactional
	public List<KhachHang> getAllKhachHangWithPageAble(PageAble pageAble) {
		return khachHangRepository.getAllKhachHangWithPageAble(pageAble);
	}
	
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = khachHangRepository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
	
	@Transactional
	public void deleteKhachHang(String maKH) {
		KhachHang khachHang = khachHangRepository.findById(maKH);
		if(khachHang != null) {
			khachHangRepository.deleteKhachHang(khachHang);
		}
	}
	
	@Transactional
	public boolean khachHangExist(String maKH) {
		return khachHangRepository.khachHangExist(maKH);
	}
	
	@Transactional
	public List<KhachHang> searchKhachHang(PageAble pageAble, String tenKH){
		return khachHangRepository.searchKhachHang(pageAble, tenKH);
	}
	
	@Transactional
	public int totalPagesSearch(PageAble pageAble, String maKH) {
		long totalRecord = khachHangRepository.countsearch(maKH);
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
}
