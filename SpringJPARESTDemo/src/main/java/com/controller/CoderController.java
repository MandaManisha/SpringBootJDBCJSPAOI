package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Coder;
import com.service.CoderService;

@RestController
@RequestMapping("api")
public class CoderController {
	
	@Autowired
	CoderService service;
	
	@GetMapping("getcoders")
	public List<Coder> getCoders()
	{
		List<Coder> lc = service.getcoders();
		return lc;
	}
	
	
	@PostMapping("addcoder")
	public Coder addCoder(@RequestBody  Coder c)
	{
		service.addCoder(c);
		return c;
		

    }
	
	@GetMapping("getcoder/{cid}")
		public Coder getcoderbyid(@PathVariable int cid)
		{
		Coder  c1=service.getCoder(cid);
		return c1;
	}
	
	@DeleteMapping("deletecoder/{cid}")
	public String deletecoderbyID(@PathVariable int cid)
	{
		
		service.deletecoder(cid);
		return "Deleted";
	}
	
	@PutMapping("updatecoder")
	public Coder updateCoder(@RequestBody Coder c)
	{
		Coder c1=service.updatecoder(c);
		return c1;
	}
	
	@GetMapping("getcoderbycname/{cname}")
	public List<Coder> getcoderbyname(@PathVariable String cname)
	{
		List<Coder> lc=service.getCoderbyname(cname);
		return lc;
	}

}
