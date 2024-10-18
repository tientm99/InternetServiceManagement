/**
 * 
 */
package tien.java.web.controller;

import java.util.List;

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

import tien.java.web.entity.KhachHang;
import tien.java.web.model.ChiTietSuDung;
import tien.java.web.page.PageAble;
import tien.java.web.service.KhachHangService;
import tien.java.web.validate.ValidatedData;

/**
 * 
 */
@Controller
@RequestMapping
@Validated
public class KhachHangController {
	
	@Autowired
	private KhachHangService khachHangService;
	
	@ModelAttribute(value = "khachhang")
	public KhachHang getKhachHang() {
		return new KhachHang();
	}

	@GetMapping("/formtaomoiKH")
	public String taoMoiKhachHang(Model model) {
		return "/khachhang/taomoikhachhang";
	}
	
	@GetMapping("/listkhachhang")
	public String danhSachKhachHang(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<KhachHang> list = khachHangService.getAllKhachHangWithPageAble(pageAble);
		model.addAttribute("listKH", list);
		model.addAttribute("totalPages", khachHangService.totalPages(pageAble));
		model.addAttribute("currentPage", page);
		return "/khachhang/danhsachkhachhang";
	}
	
	@PostMapping("/taomoikhachhang")
	public String taoMoiKhachHang(Model model,
			@Validated(ValidatedData.validSave.class) @ModelAttribute(value = "khachhang") KhachHang khachHang,
			BindingResult result) {
		if(result.hasErrors()) {
			return "/khachhang/taomoikhachhang";
		}
		khachHangService.insertKhachHang(khachHang);
		return "redirect:/listkhachhang";
	}
	@PostMapping("/capnhatkhachhang")
	public String capnhatKhachHang(Model model,
			@Validated(ValidatedData.validUpdate.class) @ModelAttribute(value = "updateKH") KhachHang khachHang,
			BindingResult result) {
		if(result.hasErrors()) {
			return "/khachhang/capnhatkhachhang";
		}
		khachHangService.insertKhachHang(khachHang);
		return "redirect:/listkhachhang";
	}
	
	@GetMapping("/deletekhachhang")
	public String deleteKhachHang(@RequestParam(name = "id") String maKH) {
		khachHangService.deleteKhachHang(maKH);
		return "redirect:/listkhachhang";
	}
	
	@RequestMapping("/updatekhachhang")
	public String updateKhachHang(@RequestParam(name = "idkh") String maKH, Model model) {
		KhachHang khachHang = khachHangService.findById(maKH);
		model.addAttribute("updateKH", khachHang);
		return "/khachhang/capnhatkhachhang";
	}
	
	@GetMapping("/searchkhachhang")
	public String searchKhachHang(Model model, @RequestParam(value = "tenkhachhang") String tenKH, @RequestParam(defaultValue = "1") Integer page) {	
		PageAble pageAble = new PageAble(page);
		List<KhachHang> list = khachHangService.searchKhachHang(pageAble, tenKH);
		model.addAttribute("listKH", list);
		model.addAttribute("totalPages", khachHangService.totalPagesSearch(pageAble, tenKH));
		model.addAttribute("currentPage", page);
		model.addAttribute("tenKH", tenKH);
		return "khachhang/searchkhachhang";
	}
}
