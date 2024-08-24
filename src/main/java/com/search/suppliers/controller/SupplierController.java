package com.search.suppliers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.search.suppliers.entity.Supplier;
import com.search.suppliers.service.SupplierService;

import jakarta.validation.constraints.Min;

import java.util.List;

@RestController
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@PostMapping("/api/supplier/query")
	public ResponseEntity<?> querySuppliers(
	        @RequestParam(required = false) String location,
	        @RequestParam(required = false) String natureOfBusiness, 
	        @RequestParam(required = false) String manufacturingProcess,
	        @RequestParam(defaultValue = "1") @Min(1) int page, 
	        @RequestParam(defaultValue = "5") @Min(1) int size) {

	    try {
	        // Checking if all search parameters are null or empty
	        if ((location == null || location.isEmpty()) &&
	            (natureOfBusiness == null || natureOfBusiness.isEmpty()) &&
	            (manufacturingProcess == null || manufacturingProcess.isEmpty())) {
	            return ResponseEntity.ok("No search criteria provided. Please provide at least one search parameter.");
	        }

	        List<Supplier> suppliers = supplierService.findSuppliers(location, natureOfBusiness, manufacturingProcess, page, size);

	        if (suppliers.isEmpty()) {
	            return ResponseEntity.ok("No result found with this keyword");
	        }

	        return ResponseEntity.ok(suppliers);

	    } catch (Exception e) {
	        return ResponseEntity.status(500).body("An error occurred while processing your request: " + e.getMessage());
	    }
	}
}
