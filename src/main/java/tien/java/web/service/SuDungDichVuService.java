/**
 * 
 */
package tien.java.web.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tien.java.web.entity.SuDungDichVu;
import tien.java.web.repository.SuDungDichVuRepository;

/**
 * 
 */
@Service
public class SuDungDichVuService {
	
	@Autowired
	private SuDungDichVuRepository suDungDichVuRepository;
	
	@Transactional
	public void insertSuDungDichVu(SuDungDichVu suDungDichVu) {
		suDungDichVuRepository.insertSuDungDichVu(suDungDichVu);
	}
}
