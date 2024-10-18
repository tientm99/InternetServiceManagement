/**
 * 
 */
package tien.java.web.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tien.java.web.entity.SuDungMay;
import tien.java.web.repository.SuDungMayRepository;

/**
 * 
 */
@Service
public class SuDungMayService {
	
	@Autowired
	private SuDungMayRepository suDungMayRepository;
	
	@Transactional
	public void insertSuDungMay(SuDungMay suDungMay) {
		suDungMayRepository.insertDangKySDMay(suDungMay);
	}
}
