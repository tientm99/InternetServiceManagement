/**
 * 
 */
package tien.java.web.controller;

import java.util.List;

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

import tien.java.web.entity.May;
import tien.java.web.page.PageAble;
import tien.java.web.service.MayService;
import tien.java.web.validate.ValidatedData;

/**
 * 
 */
@Controller
@RequestMapping
public class MayController {

	@Autowired
	private MayService mayService;

	@ModelAttribute(value = "may")
	public May getMay() {
		return new May();
	}

	@GetMapping("/formtaomoimay")
	public String formTaoMoiMay(Model model) {
		return "may/taomoimay";
	}

	@GetMapping("/listmay")
	public String danhSachMay(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<May> list = mayService.getAllMayWithPageAble(pageAble);
		model.addAttribute("listM", list);
		model.addAttribute("totalPages", mayService.totalPages(pageAble));
		model.addAttribute("currentPage", page);
		return "may/danhsachmay";
	}

	@PostMapping("/taomoimay")
	public String taoMoiMay(Model model,
			@Validated(ValidatedData.validSave.class) @ModelAttribute(name = "may") May may, BindingResult result) {
		if (result.hasErrors()) {
			return "may/taomoimay";
		}
		mayService.insertMay(may);
		return "redirect:/listmay";
	}

	@PostMapping("/capnhatmay")
	public String capNhatMay(Model model,
			@Validated(ValidatedData.validUpdate.class) @ModelAttribute(name = "updateM") May may,
			BindingResult result) {
		if (result.hasErrors()) {
			return "may/capnhatmay";
		}
		mayService.insertMay(may);
		return "redirect:/listmay";
	}

	@GetMapping("/deletemay")
	public String deleteMay(@RequestParam(name = "id") String maMay) {
		mayService.deleteMay(maMay);
		return "redirect:/listmay";
	}

	@GetMapping("/updatemay")
	public String updateMay(@RequestParam(name = "idmay") String maMay, Model model) {
		May may = mayService.findById(maMay);
		model.addAttribute("updateM", may);
		return "may/capnhatmay";
	}
	
}
