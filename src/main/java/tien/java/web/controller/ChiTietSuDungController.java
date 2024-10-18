/**
 * 
 */
package tien.java.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tien.java.web.model.ChiTietSuDung;
import tien.java.web.page.PageAble;
import tien.java.web.service.ChiTietSuDungService;

/**
 * 
 */
@Controller
@RequestMapping
@SessionAttributes
public class ChiTietSuDungController {
	
	@Autowired
	ChiTietSuDungService chiTietSuDungService;
	
	@GetMapping("/listchitietsudung")
	public String chiTietSuDung(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<ChiTietSuDung> list = chiTietSuDungService.getAllChiTietSuDung(pageAble);
		model.addAttribute("listCTSD", list);
		model.addAttribute("totalPages", chiTietSuDungService.totalPages(pageAble));
		model.addAttribute("currentPage", page);
		return "/chitietsudung/chitietsudung";
	}
	
	@GetMapping("/searchchitietsudung")
	public String searchchiTietSuDung(Model model, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(value = "tenkh") String tenKH) {
		PageAble pageAble = new PageAble(page);
		List<ChiTietSuDung> list = chiTietSuDungService.searchChiTietSuDung(pageAble, tenKH);
		model.addAttribute("listCTSD", list);
		model.addAttribute("totalPages", chiTietSuDungService.searchtotalPages(pageAble, tenKH));
		model.addAttribute("currentPage", page);
		model.addAttribute("tenKH", tenKH);
		return "/chitietsudung/searchchitietsudung";
	}
}
