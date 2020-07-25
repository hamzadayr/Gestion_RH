package com.master_isi.dayr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.master_isi.dayr.model.Remuneration;

import com.master_isi.dayr.repository.RemunerationRepository;

@Service
public class RemunerationService {
	@Autowired
	private RemunerationRepository repo;
	public List<Remuneration> listAll(){
		return repo.findAll();
		}

		public void save(Remuneration remuneration){
		   repo.save(remuneration);
		}

		public Remuneration get(Long id){
		return repo.findById(id).get();
		}

		public void delete(Long id){
		repo.deleteById(id);
		}

}
