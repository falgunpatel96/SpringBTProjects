package com.falgun.vendor.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falgun.vendor.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
