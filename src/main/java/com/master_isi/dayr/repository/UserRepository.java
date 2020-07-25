package com.master_isi.dayr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.master_isi.dayr.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
