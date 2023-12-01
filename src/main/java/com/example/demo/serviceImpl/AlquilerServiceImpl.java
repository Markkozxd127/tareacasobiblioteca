package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AlquilerDto;
import com.example.demo.entity.Alquiler;
import com.example.demo.entity.Lector;
import com.example.demo.entity.Libro;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AlquilerRepository;
import com.example.demo.repository.LectorRepository;
import com.example.demo.repository.LibroRepository;
import com.example.demo.service.AlquilerService;

import jakarta.persistence.EntityNotFoundException;




@Service
public class AlquilerServiceImpl implements AlquilerService<Alquiler> {
	
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private LectorRepository lectorRepository;

	@Override
	public Alquiler update(int id, AlquilerDto alquilerDto) {
	    Optional<Alquiler> optionaAlquiler = alquilerRepository.findById(id);

	    if (optionaAlquiler.isPresent()) {
	    	Alquiler alquiler = optionaAlquiler.get();

	        // Actualiza los campos del libro con los valores del DTO
	    	alquiler.setFechasa(alquilerDto.getFechasa());
	    	alquiler.setFechaen(alquilerDto.getFechaen());
	    

	        // Actualiza las relaciones con autor, editorial y categoría
	    	alquiler.setLibro(libroRepository.findById(alquilerDto.getLibro()).orElse(null));
	    	alquiler.setLector(lectorRepository.findById(alquilerDto.getLector()).orElse(null));
	        
	        // Guarda el libro actualizado en la base de datos
	        return alquilerRepository.save(alquiler);
	    } else {
	        throw new ResourceNotFoundException("Alquiler no encontrado con ID: " + id);
	    }
	}
	

	@Override
	public void delete(int id) {
alquilerRepository.deleteById(id);
	}

	@Override
	public Optional<Alquiler> read(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Alquiler> readAll() {
		// TODO Auto-generated method stub
		return alquilerRepository.findAll();
	}

	@Override
	public Alquiler guardarAlquiler(AlquilerDto alquilerDto) {
	    Libro libro = libroRepository.findById(alquilerDto.getLibro())
	            .orElseThrow(() -> new EntityNotFoundException("Libro not found"));
	    
	    Lector lector = lectorRepository.findById(alquilerDto.getLector())
	            .orElseThrow(() -> new EntityNotFoundException("Lector not found"));
	    
	    Alquiler alquiler = new Alquiler();
	    alquiler.setFechasa(alquilerDto.getFechasa());
	    alquiler.setFechaen(alquilerDto.getFechaen());

	    alquiler.setLibro(libro);
	    alquiler.setLector(lector);
	    return alquilerRepository.save(alquiler);
	}
}





    




	