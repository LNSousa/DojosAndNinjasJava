package com.lsousa.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsousa.dojosandninjas.models.Dojo;
import com.lsousa.dojosandninjas.repos.DojoRepo;

@Service
public class DojoService {
	@Autowired
	private DojoRepo repo;
	
	// ========== Create / Update ================

    public Dojo save(Dojo d) {
        return repo.save(d);
    }

// ========== Read ===========================

    public List<Dojo> getAll() {
        return repo.findAll();
    }

    public Dojo getOne (Long id) {
        return repo.findById(id).orElse(null);
    }

// ========== Delete =========================

    public void deleteOne (Long id) {
        repo.deleteById(id);
    }

// ========== Relationships ==================
}
