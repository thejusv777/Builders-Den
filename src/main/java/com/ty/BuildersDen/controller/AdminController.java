package com.ty.BuildersDen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.BuildersDen.dto.Admin;
import com.ty.BuildersDen.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin")
	public Admin saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@GetMapping("/admin")
	public Admin getAdminById(@RequestParam int id) {
		return adminService.getAdminById(id);
	}
	@GetMapping("/alladmin")
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmin();
	}
	
	@PutMapping("/admin")
	public Admin updateAdmin(@RequestParam int id ,@RequestBody Admin admin) {
		return adminService.updateAdmin(id, admin);
	}
	
	@DeleteMapping("/admin")
	public boolean deleteAdminById(@RequestParam int id) {
		return adminService.deleteAdmin(id);
	}
	
	@GetMapping("/emptyadmin")
	public Admin getAdmin() {
		return adminService.getAdminObject();
	}
}
