package com.ty.BuildersDen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.BuildersDen.dto.Vendor;
import com.ty.BuildersDen.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@PostMapping("/admin/{admin_id}/vendor")
	public Vendor saveVendor(@RequestBody Vendor vendor, @PathVariable int admin_id) {
		return vendorService.saveVendor(admin_id, vendor);
	}
	
	@GetMapping("/vendor")
	public Vendor getVendorById(@RequestParam int vendor_id) {
		return vendorService.getVenderById(vendor_id);
	}
	
	@GetMapping("/allvendor")
	public List<Vendor> getAllVendors(){
		return vendorService.getAllVendor();
	}
	
	@PutMapping("/vendor")
	public Vendor updateVendor(@RequestParam int id ,@RequestBody Vendor vendor) {
		return vendorService.updateVendor(id, vendor);
	}
	
	@DeleteMapping("/vendor")
	public boolean deleteVendorById(@RequestParam int vendor_id) {
		return vendorService.deleteVendor(vendor_id);
	}
	
	@GetMapping("/emptyvendor")
	public Vendor getVendor() {
		return vendorService.getVendorObject();
	}
}
