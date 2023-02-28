package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Personal;
@Repository
public interface PersonalRepository extends JpaRepository<Personal,Integer>{

	public Personal findByPnum(int pn);

}
