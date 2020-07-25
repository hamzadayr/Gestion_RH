package com.master_isi.dayr.service;

import java.util.List;
import com.master_isi.dayr.model.Employee;

public interface EmployeeService {
    Iterable<Employee> findAll();

    List<Employee> search(String q);

    Employee findOne(int id);

    void save(Employee contact);

    void delete(int id);
}