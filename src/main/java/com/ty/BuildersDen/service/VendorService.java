package com.ty.BuildersDen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.BuildersDen.dao.VendorDao;
import com.ty.BuildersDen.dto.Vendor;

@Service
public class VendorService {
	@Autowired
	VendorDao vendorDao;

	public Vendor saveVendor(int adminid, Vendor vendor) {
		return vendorDao.saveVendor(adminid, vendor);
	}

	public Vendor getVenderById(int vid) {
		return vendorDao.getVenderById(vid);
	}

	public List<Vendor> getAllVendor() {
		return vendorDao.getAllVendor();
	}

	public boolean deleteVendor(int vid) {
		return vendorDao.deleteVendor(vid);
	}

	public Vendor updateVendor(int vid, Vendor vendor) {
		return vendorDao.updateVendor(vid, vendor);
	}

	public Vendor getVendorObject() {
		return vendorDao.getVendorObject();
	}
}
