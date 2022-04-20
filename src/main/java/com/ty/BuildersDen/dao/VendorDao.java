package com.ty.BuildersDen.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.BuildersDen.dto.Admin;
import com.ty.BuildersDen.dto.Vendor;
import com.ty.BuildersDen.repository.VendorRepository;

@Repository
public class VendorDao {

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private AdminDao adminDao;

	public Vendor saveVendor(int adminid, Vendor vendor) {
		Admin admin = adminDao.getAdminById(adminid);
		if (admin != null) {
			vendor.setAdmin(admin);
			vendorRepository.save(vendor);
			return vendor;
		}
		return null;
	}

	public Vendor getVenderById(int vid) {
		Optional<Vendor> veOptional = vendorRepository.findById(vid);
		if (veOptional.isEmpty()) {
			return null;
		}
		return veOptional.get();
	}

	public List<Vendor> getAllVendor() {
		return vendorRepository.findAll();
	}

	public boolean deleteVendor(int vid) {
		Vendor vendor = getVenderById(vid);
		if (vendor != null) {
			vendorRepository.deleteById(vid);
			return true;
		}
		return false;

	}

	public Vendor updateVendor(int vid, Vendor vendor) {
		Vendor vendors = getVenderById(vid);
		if (vendors != null) {
			vendorRepository.save(vendor);
			return vendor;
		}
		return null;

	}

	public Vendor getVendorObject() {
		return new Vendor();
	}

}
