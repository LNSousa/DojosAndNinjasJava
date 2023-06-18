package com.lsousa.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsousa.dojosandninjas.models.Ninja;
import com.lsousa.dojosandninjas.repos.NinjaRepo;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepo repo;
	
	// ========== Create / Update ================

    public Ninja save(Ninja n) {
        return repo.save(n);
    }

// ========== Read ===========================

    public List<Ninja> getAll() {
        return repo.findAll();
    }

    public Ninja getOne (Long id) {
        return repo.findById(id).orElse(null);
    }

// ========== Delete =========================

    public void deleteOne (Long id) {
        repo.deleteById(id);
    }

// ========== Relationships ==================

}
