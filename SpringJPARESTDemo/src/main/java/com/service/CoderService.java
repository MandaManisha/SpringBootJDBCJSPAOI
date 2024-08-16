package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.entity.Coder;
import com.repository.CoderRepository;

@Service
public class CoderService {
	
	@Autowired
	CoderRepository repo;
	
	public List<Coder> getcoders() {
		List<Coder> lc = repo.findAll();
		
		return lc;
	}
	
	public Coder addCoder(Coder c)
	{
		repo.save(c);
		return c;
	}
	
	public Coder getCoder(int cid)
	{
		Optional<Coder> c1=repo.findById(cid);
		Coder c2=c1.get();
		return c2;
	}
	
	public List<Coder> getCoderbyname(String cname)
	{
		List<Coder> c1=repo.findByCname(cname);
		return c1;
	}
	public String deletecoder(int cid)
	{
		repo.deleteById(cid);
		return "Deleted";
	}
	
	public Coder updatecoder(Coder c) {
		int id=c.getCid();
		
		Coder c1=repo.findById(id).get();
		
		if(id==c1.getCid())
		{
			c1.setCname(c.getCname());
			c1.setTech(c.getTech());
		}
		repo.save(c1);
		
		return c1;
	}
	
	
	
	

}
