package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.LibroDto;
import com.example.demo.entity.Libro;

public interface LibroService  <T>{
    Libro update(int id, LibroDto libroDto);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();
	Libro guardarLibro(LibroDto libroDto);
}	



