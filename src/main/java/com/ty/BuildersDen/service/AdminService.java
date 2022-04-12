package com.ty.BuildersDen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.BuildersDen.dao.AdminDao;
import com.ty.BuildersDen.dto.Admin;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}

	public Admin getAdminById(int id) {
		return adminDao.getAdminById(id);
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

	Admin getAdminObject() {
		return adminDao.getAdminObject();
	}
}
