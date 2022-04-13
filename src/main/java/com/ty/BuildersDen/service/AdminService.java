package com.ty.BuildersDen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.BuildersDen.dao.AdminDao;
import com.ty.BuildersDen.dto.Admin;
import com.ty.BuildersDen.exception.IdNotFoundException;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}

	public Admin getAdminById(int id) {
		Admin admin= adminDao.getAdminById(id);
		
		if(admin== null) {
			throw new IdNotFoundException("given "+id+" does not exist");
		}
		return admin;
	}

	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();
	}

	public boolean deleteAdmin(int id) {
		return adminDao.deleteAdmin(id);
	}

	public Admin updateAdmin(int id, Admin admin) {
		return adminDao.updateAdmin(id, admin);
	}

	public Admin getAdminObject() {
		return adminDao.getAdminObject();
	}
}
