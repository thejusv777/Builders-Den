package com.ty.BuildersDen.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.BuildersDen.dto.Admin;
import com.ty.BuildersDen.repository.AdminRepository;

@Repository
public class AdminDao {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public Admin getAdminById(int id) {
		Optional<Admin> admin=adminRepository.findById(id);
		if(admin.isEmpty()) {
		   return null;
		}
		return admin.get();
	}
	
	public List<Admin> getAllAdmin(){
		return adminRepository.findAll();
	}
	
	public boolean deleteAdmin(int id) {
		Admin admin=getAdminById(id);
		if(admin!=null) {
			adminRepository.deleteById(id);
			return true;
		}
		return false;
		
	}
	
	public Admin updateAdmin(int id,Admin admin) {
		Admin admins=getAdminById(id);
		if(admins!=null) {
			adminRepository.save(admin);
			return admin;
		}
		return null;
		
	}
	
	public Admin getAdminObject() {
		return new Admin();
	}

}
