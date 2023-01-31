package com.falgun.vendor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.falgun.vendor.entities.Vendor;
import com.falgun.vendor.service.VendorService;

@Controller
public class VendorController {

	@Autowired
	VendorService service;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createVendor";
	}
	
	@RequestMapping("/saveVendor")
	public String saveVendor(@ModelAttribute("Vendor") Vendor vendor, ModelMap modelMap) {
		Vendor vendorSaved = service.saveVendor(vendor);
		String msg = "Vendor saved with id: " + vendorSaved.getId();
		modelMap.addAttribute("msg", msg);
		return "createVendor";
	}
	
	@RequestMapping("/displayVendors")
	public String displayVendors(ModelMap modelMap) {
		List<Vendor> allVendors = service.getAllVendors();
		modelMap.addAttribute("vendors", allVendors);
		return "displayVendors";
	}
	
	@RequestMapping("/editVendor")
	public String editVendor(@RequestParam("id") int id, ModelMap modelMap) {
		Vendor vendor = service.getVendorById(id);
		modelMap.addAttribute("vendor", vendor);
		return "editVendor";
	}
	
	@RequestMapping("/updateVendor")
	public String updateVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
		service.saveVendor(vendor);
		List<Vendor> allVendors = service.getAllVendors();
		modelMap.addAttribute("vendors", allVendors);
		return "displayVendors";
	}
	
	@RequestMapping("/deleteVendor")
	public String deleteVendor(@RequestParam("id") int id, ModelMap modelMap) {
		Vendor vendorTobeDeleted = service.getVendorById(id);
		service.deleteVendor(vendorTobeDeleted);
		List<Vendor> allVendors = service.getAllVendors();
		modelMap.addAttribute("vendors", allVendors);
		return "displayVendors";
	}

}
