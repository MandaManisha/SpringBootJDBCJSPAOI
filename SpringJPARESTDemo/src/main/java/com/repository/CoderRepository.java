package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Coder;

public interface CoderRepository extends JpaRepository<Coder,Integer> {
	
	public List<Coder> findByCname(String cname);
	

}
