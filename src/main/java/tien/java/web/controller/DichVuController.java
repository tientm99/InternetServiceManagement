/**
 * 
 */
package tien.java.web.controller;

import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tien.java.web.entity.DichVu;
import tien.java.web.entity.KhachHang;
import tien.java.web.page.PageAble;
import tien.java.web.service.DichVuService;
import tien.java.web.validate.ValidatedData;

/**
 * 
 */
@Controller
@RequestMapping
public class DichVuController {

	@Autowired
	private DichVuService dichVuService;

	@ModelAttribute(value = "dichvu")
	public DichVu getDichVu() {
		return new DichVu();
	}

	@GetMapping("/formTaoMoiDV")
	public String formtaoMoiDichVu(Model model) {
		return "dichvu/taomoidichvu";
	}

	@GetMapping("/listdichvu")
	public String danhSachDichVu(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<DichVu> list = dichVuService.getAllDichVuWithPageAble(pageAble);
		model.addAttribute("listDV", list);
		model.addAttribute("totalPages", dichVuService.totalPages(pageAble));
		model.addAttribute("currentPage", page);
		return "dichvu/danhsachdichvu";
	}

	@PostMapping("/taomoidichvu")
	public String taoMoiDichVu(Model model,
			@Validated(ValidatedData.validSave.class) @ModelAttribute(value = "dichvu") DichVu dichVu,
			BindingResult result) {
		if (result.hasErrors()) {
			return "dichvu/taomoidichvu";
		}
		dichVuService.insertDichVu(dichVu);
		return "redirect:/listdichvu";
	}

	@PostMapping("/capnhatdichvu")
	public String capNhatDichVu(Model model,
			@Validated(ValidatedData.validUpdate.class) @ModelAttribute(value = "updateDV") DichVu dichVu,
			BindingResult result) {
		if (result.hasErrors()) {
			return "dichvu/capnhatdichvu";
		}
		dichVuService.insertDichVu(dichVu);
		return "redirect:/listdichvu";
	}

	@GetMapping("/deletedichvu")
	public String deleteDichVu(@RequestParam(name = "id") String maDV) {
		dichVuService.deleteDichVu(maDV);
		return "redirect:/listdichvu";
	}

	@GetMapping("/updatedichvu")
	public String updateDichVu(@RequestParam(name = "iddv") String maDV, Model model) {
		DichVu dichVu = dichVuService.findById(maDV);
		model.addAttribute("updateDV", dichVu);
		return "dichvu/capnhatdichvu";
	}
	
	@GetMapping("/searchdichvu")
	public String searchDichVu(Model model, @RequestParam(name = "tendichvu") String tenDV, @RequestParam(defaultValue = "1") Integer page) {
		
		PageAble pageAble = new PageAble(page);
		List<DichVu> list = dichVuService.searchDichVu(pageAble, tenDV);
		model.addAttribute("listDV", list);
		model.addAttribute("totalPages", dichVuService.totalPagesSearch(pageAble, tenDV));
		model.addAttribute("currentPage", page);
		model.addAttribute("tenDV", tenDV);
		return "dichvu/searchdichvu";
	}
}
