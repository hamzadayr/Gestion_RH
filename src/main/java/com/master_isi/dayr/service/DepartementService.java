package com.master_isi.dayr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master_isi.dayr.model.Departement;
import com.master_isi.dayr.repository.DepartementRepository;




@Service
public class DepartementService {
	@Autowired
	private DepartementRepository repo;
	public List<Departement> listAll(){
		return repo.findAll();
		}

		public void save(Departement departement){
		   repo.save(departement);
		}

		public Departement get(Long id){
		return repo.findById(id).get();
		}

		public void delete(Long id){
		repo.deleteById(id);
		}


}
