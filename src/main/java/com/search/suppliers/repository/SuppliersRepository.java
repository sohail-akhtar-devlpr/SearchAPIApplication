package com.search.suppliers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//this is just the demo for using the actual database.
public interface SuppliersRepository extends JpaRepository<T, ID> {
	// I use this interface when I worked with an actual database.
}
