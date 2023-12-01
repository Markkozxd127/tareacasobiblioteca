package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LibroDto;
import com.example.demo.entity.Autor;
import com.example.demo.entity.Categoria;
import com.example.demo.entity.Editorial;
import com.example.demo.entity.Libro;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.EditorialRepository;
import com.example.demo.serviceImpl.LibroServiceImpl;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.demo.commons.GlobalConstans.API_LIBROS;;

@RestController
@RequestMapping(API_LIBROS)
@CrossOrigin({"*"})
public class LibroController {
	
	@Autowired
	private LibroServiceImpl libroServiceImpl;
		
	@GetMapping("/ListBook")
	public ResponseEntity<List<Libro>> listar() {
		try {
		      List<Libro> lib = libroServiceImpl.readAll();
		      if (lib.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(lib, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	

	
	@GetMapping("/BuscarBook/{id}")
	public ResponseEntity<Libro> getLibroById(@PathVariable("id") int id){
		Optional<Libro> carData = libroServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Libro>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	  @PostMapping("/InsertLibro")
	    public ResponseEntity<Libro> crear(@Valid @RequestBody LibroDto libroDto ) {
	        try {
	            Libro libro = libroServiceImpl.guardarLibro(libroDto);
	            return new ResponseEntity<>(libro, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
	@DeleteMapping("/DeleteBook/{id}")
	public ResponseEntity<Libro> delete(@PathVariable("id") int id){
		try {
			libroServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
    @PutMapping("/EditBook/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable("id") int id, @Valid @RequestBody LibroDto libroDto) {
        try {
            Libro updatedLibro = libroServiceImpl.update(id, libroDto);
            return new ResponseEntity<>(updatedLibro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}