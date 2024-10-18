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

import tien.java.web.entity.KhachHang;
import tien.java.web.entity.May;
import tien.java.web.entity.SuDungMay;
import tien.java.web.service.KhachHangService;
import tien.java.web.service.MayService;
import tien.java.web.service.SuDungMayService;
import tien.java.web.validate.ValidatedData;

/**
 * 
 */
@Controller
@RequestMapping
public class SuDungMayController {

	@Autowired
	private SuDungMayService suDungMayService;

	@Autowired
	private KhachHangService khachHangService;

	@Autowired
	private MayService mayService;

	@ModelAttribute(value = "sudungmay")
	public SuDungMay getSDMay() {
		return new SuDungMay();
	}

	@GetMapping("/formsudungmay")
	public String formSuDungMay(Model model) {
		return "may/sudungmay";
	}

	@PostMapping("/dangkysdmay")
	public String suDungMay(Model model,
			@Valid @Validated(ValidatedData.validSave.class) @ModelAttribute(value = "sudungmay") SuDungMay suDungMay,
			BindingResult result) {
		if (result.hasErrors()) {
			return "may/sudungmay";
		}
		KhachHang khachHang = khachHangService.findById(suDungMay.getId().getMaKH());
		May may = mayService.findById(suDungMay.getId().getMaMay());
		if (khachHang == null && may == null) {
			model.addAttribute("errorKhachHang", "Mã khách hàng không tồn tại");
			model.addAttribute("errorMay", "Mã máy tại không tồn tại");
			return "may/sudungmay";
		} else if (khachHang == null) {
			model.addAttribute("errorKhachHang", "Mã khách hàng không tồn tại");
			return "may/sudungmay";
		} else if(may == null){
			model.addAttribute("errorMay", "Mã máy tại không tồn tại");
			return "may/sudungmay";
		}

		suDungMay.setMaKH(khachHang);
		suDungMay.setMaMay(may);
		suDungMayService.insertSuDungMay(suDungMay);
		return "redirect:/listchitietsudung";

	}
}
