package com.nestkart.frontend.Controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nestkart.backend.DAO.CategoryDAO;
import com.nestkart.backend.DAO.SubCategoryDAO;
import com.nestkart.backend.Model.SubCategory;

@Controller
public class SubCategoryController {
	@Autowired
	SubCategoryDAO subcategorydao;

	@Autowired
	CategoryDAO categorydao;

	@RequestMapping(value = "/subcategory", method = RequestMethod.GET)
	String addSubCategory(Model M) {
		M.addAttribute("subcategory", new SubCategory());
		M.addAttribute("subcatlist", subcategorydao.selectAll());
		M.addAttribute("catlist", categorydao.selectAll());
		M.addAttribute("info", false);
		M.addAttribute("message", "");
		M.addAttribute("editmode", false);
		M.addAttribute("subcategorypage", true);
		return "index";
	}

	@RequestMapping(value = "/subcategory", method = RequestMethod.POST)
	String addSubCategory(@Valid @ModelAttribute("subcategory") SubCategory subcat, BindingResult br, Model M) {
		try {

			if (br.hasErrors()) {
				
				M.addAttribute("message", "Please check your data");
				M.addAttribute("subcategory", subcat);
			} else {
				if (subcategorydao.add(subcat)) {

					M.addAttribute("message", "SubCategory updated");
					M.addAttribute("subcategory", new SubCategory());
				}
			}
		} catch (Exception e) {

			if (e instanceof SQLException) {

				M.addAttribute("message", "Try After Sometime");
			} else if (e instanceof DataIntegrityViolationException) {

				M.addAttribute("message", "SubCategory Already Exists");
			}
			M.addAttribute("subcategory", subcat);
		}
		M.addAttribute("info", true);
		M.addAttribute("catlist", categorydao.selectAll());
		M.addAttribute("subcatlist", subcategorydao.selectAll());
		M.addAttribute("subcategorypage", true);
		M.addAttribute("editmode", false);
		return "index";
	}

	@RequestMapping(value = "/deletesubcategory")
	String deleteSubCategory(Model M, @RequestParam("subcatid") int id) {
		if (subcategorydao.delete(subcategorydao.selectOne(id))) {
			M.addAttribute("message", "SubCategory Deleted");
		} else {
			M.addAttribute("message", "SubCategory Not Deleted");
		}
		M.addAttribute("editmode", false);
		M.addAttribute("catlist", categorydao.selectAll());
		M.addAttribute("subcategory", new SubCategory());
		M.addAttribute("subcatlist", subcategorydao.selectAll());
		M.addAttribute("info", true);
		M.addAttribute("subcategorypage", true);

		return "index";
	}

	@RequestMapping(value = "/editsubcategory", method = RequestMethod.GET)
	String editSubCategory(Model M, @RequestParam("subcatid") int id) {
		M.addAttribute("editmode", true);
		M.addAttribute("catlist", categorydao.selectAll());
		M.addAttribute("subcategory", subcategorydao.selectOne(id));
		M.addAttribute("subcatlist", subcategorydao.selectAll());
		M.addAttribute("info", false);
		M.addAttribute("subcategorypage", true);
		return "index";
	}

	@RequestMapping(value = "/updatesubcategory", method = RequestMethod.POST)
	String updateSubCategory(@Valid @ModelAttribute("subcategory") SubCategory subcat, BindingResult br, Model M) {
		try {

			if (br.hasErrors()) {

				M.addAttribute("message", "Please check your data");
				M.addAttribute("subcategory", subcat);
			} else {

				if (subcategorydao.update(subcat)) {

					M.addAttribute("message", "SubCategory updated");
					M.addAttribute("Subcategory", new SubCategory());
				}
			}
		} catch (Exception e) {

			if (e instanceof SQLException) {

				M.addAttribute("message", "Try After Sometime");
			} else if (e instanceof DataIntegrityViolationException) {

				M.addAttribute("message", "SubCategory Already Exists");
			}

			M.addAttribute("subcategory", subcat);
		}
		M.addAttribute("editmode", false);
		M.addAttribute("info", true);
		M.addAttribute("catlist", categorydao.selectAll());
		M.addAttribute("subcatlist", subcategorydao.selectAll());
		M.addAttribute("subcategorypage", true);
		return "index";
	}

}
