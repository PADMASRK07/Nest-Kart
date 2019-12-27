
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
import com.nestkart.backend.Model.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categorydao;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	String addCategory(Model M) {
		M.addAttribute("category", new Category());
		M.addAttribute("catlist", categorydao.selectAll());
		M.addAttribute("info", false);
		M.addAttribute("message", "");
		M.addAttribute("editmode", false);
		M.addAttribute("categorypage", true);
		return "index";
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	String addCategory(@Valid @ModelAttribute("category") Category cat, BindingResult br, Model M) {
		try {

			if (br.hasErrors()) {

				M.addAttribute("message", "Please check your data");
				M.addAttribute("category", cat);
			} else {
				if (categorydao.add(cat)) {

					M.addAttribute("message", "Category Added");
					M.addAttribute("category", new Category());
				}
			}
		} catch (Exception e) {

			if (e instanceof SQLException) {

				M.addAttribute("message", "Try After Sometime");
			} else if (e instanceof DataIntegrityViolationException) {

				M.addAttribute("message", "Category Already Exists");
			}
			M.addAttribute("category", cat);
		}
		M.addAttribute("info", true);
		M.addAttribute("catlist", categorydao.selectAll());
		M.addAttribute("categorypage", true);
		M.addAttribute("editmode", false);
		return "index";
	}

	@RequestMapping(value = "/deletecategory")
	String deleteCategory(Model M, @RequestParam("catid") int id) {
		if (categorydao.delete(categorydao.selectOne(id))) {
			M.addAttribute("message", "Category Deleted");
		} else {
			M.addAttribute("message", "Category Not Deleted");
		}
		M.addAttribute("editmode", false);
		M.addAttribute("category", new Category());
		M.addAttribute("catlist", categorydao.selectAll());
		M.addAttribute("info", true);
		M.addAttribute("categorypage", true);

		return "index";
	}

	@RequestMapping(value = "/editcategory", method = RequestMethod.GET)
	String editCategory(Model M, @RequestParam("catid") int id) {
		M.addAttribute("editmode", true);
		M.addAttribute("category", categorydao.selectOne(id));
		M.addAttribute("catlist", categorydao.selectAll());
		M.addAttribute("info", false);
		M.addAttribute("categorypage", true);
		return "index";
	}

	@RequestMapping(value = "/updatecategory", method = RequestMethod.POST)
	String updateCategory(@Valid @ModelAttribute("category") Category cat, BindingResult br, Model M) {
		try {
			
			if (br.hasErrors()) {
				
				M.addAttribute("message", "Please check your data");
				M.addAttribute("category", cat);
			} else {
			
				if (categorydao.update(cat)) {
					
					M.addAttribute("message", "Category updated");
					M.addAttribute("category", new Category());
				}
			}
		} catch (Exception e) {
			
			if (e instanceof SQLException) {
				
				M.addAttribute("message", "Try After Sometime");
			} else if (e instanceof DataIntegrityViolationException) {
				
				M.addAttribute("message", "Category Already Exists");
			}
			M.addAttribute("category", cat);
		}
		M.addAttribute("editmode", false);
		M.addAttribute("info", true);
		M.addAttribute("catlist", categorydao.selectAll());
		M.addAttribute("categorypage", true);
		return "index";
	}

}
