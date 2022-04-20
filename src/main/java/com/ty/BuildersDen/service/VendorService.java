package com.ty.BuildersDen.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.BuildersDen.dao.VendorDao;
import com.ty.BuildersDen.dto.Vendor;
import com.ty.BuildersDen.exception.IdNotFoundException;

@Service
public class VendorService {
	@Autowired
	VendorDao vendorDao;

	public Vendor saveVendor(int adminid, Vendor vendor) {
		return vendorDao.saveVendor(adminid, vendor);
	}

	public Vendor setRating(int vendor_id, int rating) {
		Vendor vendor = getVenderById(vendor_id);
		if (vendor != null) {
			vendor.setRating(rating);
			vendorDao.updateVendor(vendor_id, vendor);
			return vendor;
		}
		return null;
	}

	public Vendor getVenderById(int id) {
		Vendor vendor = vendorDao.getVenderById(id);
		if (vendor == null) {
			throw new IdNotFoundException("Given " + id + " Not Exit ");
		}
		return vendor;
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
