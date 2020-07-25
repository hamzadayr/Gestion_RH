package com.master_isi.dayr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.master_isi.dayr.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findByNameContaining(String q);


}