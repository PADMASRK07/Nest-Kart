package com.nestkart.frontend.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.nestkart.backend.DAO.CategoryDAO;
import com.nestkart.backend.DAO.ProductDAO;
import com.nestkart.backend.DAO.SubCategoryDAO;
import com.nestkart.backend.Model.Category;
import com.nestkart.backend.Model.Product;
import com.nestkart.backend.Model.SubCategory;

@Controller
public class ProductController {
	@Autowired
	CategoryDAO categorydao;
	@Autowired
	SubCategoryDAO subcategorydao;
	@Autowired
	ProductDAO productdao;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	String addProduct(Model M) {
		M.addAttribute("product", new Product());
		M.addAttribute("prolist", productdao.selectAll());
		M.addAttribute("catlist", categorydao.selectAll());
		M.addAttribute("subcategory", new SubCategory());
		M.addAttribute("subcatlist", subcategorydao.selectAll());
		M.addAttribute("info", false);
		M.addAttribute("message", "");
		M.addAttribute("editmode", false);
		M.addAttribute("productpage", true);
		return "index";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	String addProduct(@Valid @ModelAttribute("product") Product pro, BindingResult br, Model M) {
		try {

			if (br.hasErrors()) {

				M.addAttribute("message", "Please check your data");
				M.addAttribute("product", pro);
			} else {
				if (productdao.add(pro)) {
					String status = uploadImage(pro.getPro_id(), pro.getPimage());
					status = "Product updated & " + status;
					M.addAttribute("message", status);
					M.addAttribute("product", new Product());
				}
			}
		} catch (Exception e) {

			if (e instanceof SQLException) {

				M.addAttribute("message", "Try After Sometime");
			} else if (e instanceof DataIntegrityViolationException) {

				M.addAttribute("message", "Product Already Exists");
			}
			M.addAttribute("product", pro);
		}
		M.addAttribute("info", true);
		M.addAttribute("prolist", productdao.selectAll());
		M.addAttribute("subcategory", new SubCategory());
		M.addAttribute("subcatlist", subcategorydao.selectAll());
		M.addAttribute("productpage", true);
		M.addAttribute("editmode", false);
		return "index";
	}

	private String uploadImage(int pro_id, MultipartFile pimage) {
		if (!pimage.isEmpty()) {
			try {
				byte myimage[] = pimage.getBytes();
				String path = "C:\\Users\\hp\\PADMA\\frontend\\src\\main\\webapp\\resources\\productimages\\";
				path = path + String.valueOf(pro_id) + ".jpg";
				File f = new File(path);
				if (f.exists()) {
					f.delete();
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(f));
					bs.write(myimage);
					bs.close();
					return "Image Updated";
				} else {
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(f));
					bs.write(myimage);
					bs.close();
					return "Image Added";
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Image not Added";
			}

		}
		return "Pls Try Adding Image";
	}

	@RequestMapping(value = "/deleteproduct")
	String deleteProduct(Model M, @RequestParam("proid") int id) {
		if (productdao.delete(productdao.selectOne(id))) {
			String status = deleteImage(id);
			status = "Product Deleted & " + status;
			M.addAttribute("message", status);
		} else {
			M.addAttribute("message", "Product Not Deleted");
		}
		M.addAttribute("editmode", false);
		M.addAttribute("product", new Product());
		M.addAttribute("prolist", productdao.selectAll());
		M.addAttribute("info", true);
		M.addAttribute("subcategory", new SubCategory());
		M.addAttribute("subcatlist", subcategorydao.selectAll());
		M.addAttribute("productpage", true);

		return "index";
	}

	private String deleteImage(int id) {
		String path = "C:\\Users\\hp\\PADMA\\frontend\\src\\main\\webapp\\resources\\productimages\\";
		path = path + String.valueOf(id) + ".jpg";
		File f = new File(path);
		if (f.exists()) {
			f.delete();
			return "Image Deleted";
		} else {
			return "No image to Delete";

		}
	}

	@RequestMapping(value = "/editproduct", method = RequestMethod.GET)
	String editProduct(Model M, @RequestParam("proid") int id) {
		M.addAttribute("editmode", true);
		M.addAttribute("product", productdao.selectOne(id));
		M.addAttribute("prolist", productdao.selectAll());
		M.addAttribute("info", false);
		M.addAttribute("subcategory", new SubCategory());
		M.addAttribute("subcatlist", subcategorydao.selectAll());
		M.addAttribute("productpage", true);
		return "index";
	}

	@RequestMapping(value = "/updateproduct", method = RequestMethod.POST)
	String updateProduct(@Valid @ModelAttribute("product") Product pro, BindingResult br, Model M) {
		try {

			if (br.hasErrors()) {

				M.addAttribute("message", "Please check your data");
				M.addAttribute("product", pro);
			} else {

				if (productdao.update(pro)) {
					String status = uploadImage(pro.getPro_id(), pro.getPimage());
					status = "Product updated & " + status;
					M.addAttribute("message", status);
					M.addAttribute("product", new Product());
				}
			}
		} catch (Exception e) {

			if (e instanceof SQLException) {

				M.addAttribute("message", "Try After Sometime");
			} else if (e instanceof DataIntegrityViolationException) {

				M.addAttribute("message", "product Already Exists");
			}
			M.addAttribute("product", pro);
		}
		M.addAttribute("editmode", false);
		M.addAttribute("info", true);
		M.addAttribute("prolist", productdao.selectAll());
		M.addAttribute("subcategory", new SubCategory());
		M.addAttribute("subcatlist", subcategorydao.selectAll());
	
		M.addAttribute("productpage", true);
		return "index";
	}

}
