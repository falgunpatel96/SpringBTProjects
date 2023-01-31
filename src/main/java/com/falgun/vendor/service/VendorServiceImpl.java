package com.falgun.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falgun.vendor.entities.Vendor;
import com.falgun.vendor.repos.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	VendorRepository repo;

	@Override
	public Vendor saveVendor(Vendor vendor) {
		return repo.save(vendor);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		return repo.save(vendor);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		repo.delete(vendor);
	}

	@Override
	public Vendor getVendorById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Vendor> getAllVendors() {
		return repo.findAll();
	}

}
