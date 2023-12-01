package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Editorial;
import com.example.demo.repository.EditorialRepository;
import com.example.demo.service.EditorialService;

@Service
public class EditorialServiceImpl implements EditorialService<Editorial>{
	
	@Autowired
	private EditorialRepository editorialRepository;

	@Override
	public Editorial create(Editorial t) {
		// TODO Auto-generated method stub
		return editorialRepository.save(t);
	}

	@Override
	public Editorial update(Editorial t) {
		// TODO Auto-generated method stub
		return editorialRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		editorialRepository.deleteById(id);
	}

	@Override
	public Optional<Editorial> read(int id) {
		// TODO Auto-generated method stub
		return editorialRepository.findById(id);
	}

	@Override
	public List<Editorial> readAll() {
		// TODO Auto-generated method stub
		return editorialRepository.findAll();
	}

}
