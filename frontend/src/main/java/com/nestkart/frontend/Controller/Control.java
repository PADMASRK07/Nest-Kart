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

import com.nestkart.backend.DAO.CategoryDAO;
import com.nestkart.backend.DAO.CustomerDAO;
import com.nestkart.backend.Model.Category;
import com.nestkart.backend.Model.Customer;

@Controller
public class Control {

	@Autowired
	CustomerDAO customerdao;
	

	@RequestMapping("/")
	String indexpage(Model M) {
		M.addAttribute("sliderpage", true);
		return "index";
	}

	@RequestMapping("homepage")
	String homepage(Model M) {
		M.addAttribute("sliderpage", true);
		return "index";
	}
	

	@RequestMapping("/aboutus")
	String aboutpage(Model M) {
		M.addAttribute("aboutuspage", true);
		return "index";
	}

	@RequestMapping("/contactus")
	String contactpage(Model M) {
		M.addAttribute("contactuspage", true);
		return "index";
	}

	@RequestMapping("/login")
	String loginpage(Model M) {
		M.addAttribute("loginpage", true);
		return "index";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	String register(Model M) {
		M.addAttribute("customer", new Customer());
		M.addAttribute("registerpage", true);
		return "index";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	String addUser(@Valid @ModelAttribute("customer") Customer c, BindingResult br, Model M) {
		try {
			if (br.hasErrors()) {
				M.addAttribute("message", "Please check your data");
				M.addAttribute("customer", c);
			} else {
				if (customerdao.add(c)) {
					M.addAttribute("message", "You have Registered.Login To Continue");
					M.addAttribute("customer", new Customer());
				}
			}
		} catch (Exception e) {
			if (e instanceof SQLException) {
				M.addAttribute("message", "Try After Sometime");
			} else if (e instanceof DataIntegrityViolationException) {
				M.addAttribute("message", "UserAlready Exists");
			}
			M.addAttribute("customer", c);
		}
		M.addAttribute("info", true);
		M.addAttribute("registerpage", true);
		return "index";
	}


}
