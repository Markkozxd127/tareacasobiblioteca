package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Autor;
import com.example.demo.repository.AutorRepository;
import com.example.demo.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService<Autor>{
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public Autor create(Autor t) {
		// TODO Auto-generated method stub
		return autorRepository.save(t);
	}

	@Override
	public Autor update(Autor t) {
		// TODO Auto-generated method stub
		return autorRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		autorRepository.deleteById(id);
	}

	@Override
	public Optional<Autor> read(int id) {
		// TODO Auto-generated method stub
		return autorRepository.findById(id);
	}

	@Override
	public List<Autor> readAll() {
		// TODO Auto-generated method stub
		return autorRepository.findAll();
	}

}