/**
 * 
 */
package tien.java.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tien.java.web.entity.DichVu;
import tien.java.web.entity.KhachHang;
import tien.java.web.page.PageAble;
import tien.java.web.repository.DichVuRepository;

/**
 * 
 */
@Service
public class DichVuService {
	
	@Autowired
	private DichVuRepository dichVuRepository;
	
	@Transactional
	public void insertDichVu(DichVu dichVu) {
		dichVuRepository.insertDichVu(dichVu);
	}
	
	@Transactional
	public DichVu findById(String maDV) {
		return dichVuRepository.findById(maDV);
	}
	
	@Transactional
	public List<DichVu> getAllDichVu() {
		return dichVuRepository.getAllDichVu();
	}
	
	@Transactional
	public List<DichVu> getAllDichVuWithPageAble(PageAble pageAble) {
		return dichVuRepository.getAllDichVuWithPageAble(pageAble);
	}
	
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = dichVuRepository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
	
	@Transactional
	public void deleteDichVu(String maDV) {
		DichVu dichVu = dichVuRepository.findById(maDV);
		if(dichVu != null) {
			dichVuRepository.deleteDichVu(dichVu);
		}
	}
	
	@Transactional
	public boolean dichVuExist(String maDV) {
		return dichVuRepository.dichVuExist(maDV);
	}
	
	@Transactional
	public List<DichVu> searchDichVu(PageAble pageAble, String tenDV){
		return dichVuRepository.searchDichVu(pageAble, tenDV);
	}
	
	@Transactional
	public int totalPagesSearch(PageAble pageAble, String tenDV) {
		long totalRecord = dichVuRepository.countSearch(tenDV);
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
}
