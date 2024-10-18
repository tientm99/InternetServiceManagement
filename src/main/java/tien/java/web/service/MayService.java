/**
 * 
 */
package tien.java.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tien.java.web.entity.KhachHang;
import tien.java.web.entity.May;
import tien.java.web.entity.SuDungMay;
import tien.java.web.page.PageAble;
import tien.java.web.repository.MayRepository;

/**
 * 
 */
@Service
public class MayService {

	@Autowired
	private MayRepository mayRepository;

	@Transactional
	public void insertMay(May may) {
		mayRepository.insertMay(may);
	}

	@Transactional
	public May findById(String maMay) {
		return mayRepository.findById(maMay);
	}

	@Transactional
	public List<May> getAllMay() {
		return mayRepository.getAllMay();
	}
	
	@Transactional
	public List<May> getAllMayWithPageAble(PageAble pageAble) {
		return mayRepository.getAllMayWithPageAble(pageAble);
	}
	
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = mayRepository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
	
	@Transactional
	public void deleteMay(String maMay) {
		May may = mayRepository.findById(maMay);
		if (may != null) {
			mayRepository.deleteMay(may);
		}
	}
	
	@Transactional
	public boolean mayExist(String maMay) {
		return mayRepository.mayExist(maMay);
	}
}
