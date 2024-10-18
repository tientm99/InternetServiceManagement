/**
 * 
 */
package tien.java.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tien.java.web.model.ChiTietSuDung;
import tien.java.web.page.PageAble;
import tien.java.web.repository.ChiTietSuDungRepository;

/**
 * 
 */
@Service
public class ChiTietSuDungService {

	@Autowired
	private ChiTietSuDungRepository chiTietSuDungRepository;
	
	@Transactional
	public List<ChiTietSuDung> chiTietSuDung(){
		return chiTietSuDungRepository.chiTietSuDung();
	}
	
	@Transactional
	public List<ChiTietSuDung> getAllChiTietSuDung(PageAble pageAble){
		return chiTietSuDungRepository.getAllChiTietSuDung(pageAble);
	}
	
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = chiTietSuDungRepository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
	
	@Transactional
	public List<ChiTietSuDung> searchChiTietSuDung(PageAble pageAble, String tenKH){
		return chiTietSuDungRepository.searchChiTietSuDung(pageAble, tenKH);
	}
	
	@Transactional
	public int searchtotalPages(PageAble pageAble, String tenKH) {
		long totalRecord = chiTietSuDungRepository.countSearch(tenKH);
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
}
