package com.search.suppliers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.search.suppliers.entity.Supplier;

@Service
public class SupplierService {

	private List<Supplier> suppliers;

	public SupplierService() {
		suppliers = new ArrayList<>();

		// Populating a dummy data
		suppliers.add(new Supplier("1", "ABC Manufacturing", "http://abc.com", "India", "smallscale",
				Set.of("3_dprinting", "moulding")));
				
		suppliers.add(new Supplier("2", "ABC Manufacturing", "http://abcd.com", "Brazil", "smallscale",
				Set.of("3dprinting", "moulding","casting")));
		
		suppliers.add(new Supplier("3", "ABC Manufacturing", "http://abcde.com", "Finland", "smallscale",
				Set.of("moulding")));
		
		suppliers.add(new Supplier("4", "XYZ Industries", "http://xyz.com", "china", "mediumscale",
				Set.of("casting", "coating")));
		
		suppliers.add(new Supplier("5", "DEF Corp", "http://def.com", "ireland", "smallscale",
				Set.of("3dprinting", "coating")));
		
		suppliers.add(new Supplier("4", "GHI Solutions", "http://ghi.com", "USA", "smallscale",
				Set.of("3dprinting", "moulding")));
		
		suppliers.add(new Supplier("10", "Mu Industries", "http://www.muindustries.com", "Canada", "large_scale", 
				Set.of("casting", "3dprinting")));
		
		suppliers.add(new Supplier("15", "Nu Moulding Co.", "http://www.numoulding.com", "Netherlands", "small_scale", 
				Set.of("moulding")));
		
		suppliers.add(new Supplier("14", "Xi 3D Print", "http://www.xi3dprint.com", "Singapore", "medium_scale", 
				Set.of("3d_printing")));
		
		suppliers.add(new Supplier("15", "Omicron Casting", "http://www.omicroncasting.com", "Denmark", "large_scale", 
				Set.of("casting")));
		
		suppliers.add(new Supplier("16", "Pi Coatings", "http://www.picoatings.com", "Sweden", "small_scale", 
				Set.of("coating")));
		
		suppliers.add(new Supplier("17", "Rho Manufacturing", "http://www.rhomfg.com", "Australia", "medium_scale", 
				Set.of("moulding", "3d_printing")));
		
		suppliers.add(new Supplier("18", "Sigma Industries", "http://www.sigmaindustries.com", "Germany", "large_scale", 
				Set.of("casting", "coating")));
		
		suppliers.add(new Supplier("19", "Tau Moulding", "http://www.taumoulding.com", "Switzerland", "small_scale", 
				Set.of("moulding")));
		
		suppliers.add(new Supplier("20", "Upsilon 3D Printing", "http://www.upsilon3d.com", "Norway", "medium_scale", 
				Set.of("3d_printing")));

	}

	public List<Supplier> findSuppliers(String location, String natureOfBusiness, String manufacturingProcess, int page, int size) {
	    return suppliers.stream()
	            .filter(s -> location == null || s.getLocation().equalsIgnoreCase(location))
	            .filter(s -> natureOfBusiness == null || s.getNatureOfBusiness().equalsIgnoreCase(natureOfBusiness))
	            .filter(s -> manufacturingProcess == null || s.getManufacturingProcesses().contains(manufacturingProcess))
	            .skip((page - 1) * size)
	            .limit(size)
	            .collect(Collectors.toList());
	}

}
