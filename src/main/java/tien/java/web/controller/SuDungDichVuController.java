/**
 * 
 */
package tien.java.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tien.java.web.entity.DichVu;
import tien.java.web.entity.KhachHang;
import tien.java.web.entity.SuDungDichVu;
import tien.java.web.service.DichVuService;
import tien.java.web.service.KhachHangService;
import tien.java.web.service.SuDungDichVuService;
import tien.java.web.validate.ValidatedData;

/**
 * 
 */
@Controller
@RequestMapping
public class SuDungDichVuController {
	
	@Autowired
	private SuDungDichVuService suDungDichVuService;
	
	@Autowired
	private DichVuService dichVuService;
	
	@Autowired
	private KhachHangService khachHangService;
	
	@ModelAttribute(value = "sudungDV")
	public SuDungDichVu getSuDungDichVu() {
		return new SuDungDichVu();
	}
	
	@GetMapping("/formDangkySDDV")
	public String formdangKySuDungDV(Model model) {
		return "dichvu/dangkysddv";
	}

	@PostMapping("/sudungdichvu")
	public String suDungDichVu(Model model,
			@Valid @Validated(ValidatedData.validSave.class) @ModelAttribute(value = "sudungDV") SuDungDichVu suDungDichVu,
			BindingResult result) {
		if (result.hasErrors()) {
			return "dichvu/dangkysddv";
		}
		DichVu dichVu = dichVuService.findById(suDungDichVu.getId().getMaDV());
		KhachHang khachHang = khachHangService.findById(suDungDichVu.getId().getMaKH());
		if (khachHang == null && dichVu == null) {
			model.addAttribute("errorKhachHang", "Mã khách hàng không tồn tại");
			model.addAttribute("errorDichVu", "Mã dịch vụ không tồn tại");
			return "dichvu/dangkysddv";
		} else if (khachHang == null) {
			model.addAttribute("errorKhachHang", "Mã khách hàng không tồn tại");
			return "dichvu/dangkysddv";
		} else if(dichVu == null){
			model.addAttribute("errorDichVu", "Mã dịch vụ tại không tồn tại");
			return "dichvu/dangkysddv";
		}

		suDungDichVu.setMaDV(dichVu);
		suDungDichVu.setMaKH(khachHang);
		suDungDichVuService.insertSuDungDichVu(suDungDichVu);
		return "redirect:/listchitietsudung";
	}
}
