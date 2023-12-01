package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.AlquilerDto;
import com.example.demo.entity.Alquiler;

public interface AlquilerService <T>{
    Alquiler update(int id, AlquilerDto alquilerDto);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();
	Alquiler guardarAlquiler(AlquilerDto alquilerDto);
}	



