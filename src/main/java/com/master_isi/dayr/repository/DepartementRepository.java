package com.master_isi.dayr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master_isi.dayr.model.Departement;
import com.master_isi.dayr.model.User;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
	

}
