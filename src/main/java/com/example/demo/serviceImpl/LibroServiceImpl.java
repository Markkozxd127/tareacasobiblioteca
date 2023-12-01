package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LibroDto;
import com.example.demo.entity.Autor;
import com.example.demo.entity.Categoria;
import com.example.demo.entity.Editorial;
import com.example.demo.entity.Libro;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.EditorialRepository;
import com.example.demo.repository.LibroRepository;
import com.example.demo.service.LibroService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LibroServiceImpl implements LibroService<Libro>{

	
	@Autowired
	private LibroRepository libroRepository ;
	
	@Autowired
	private AutorRepository autorRepository ;

	@Autowired
	private CategoriaRepository categoriaRepository ;

	@Autowired
	private EditorialRepository  editorialRepository;


	@Override
	public Libro update(int id, LibroDto libroDto) {
	    Optional<Libro> optionalLibro = libroRepository.findById(id);

	    if (optionalLibro.isPresent()) {
	        Libro libro = optionalLibro.get();

	        // Actualiza los campos del libro con los valores del DTO
	        libro.setTitulo(libroDto.getTitulo());
	        libro.setFechalan(libroDto.getFechalan());
	        libro.setIdioma(libroDto.getIdioma());
	        libro.setPaginas(libroDto.getPaginas());
	        libro.setDescripcion(libroDto.getDescripcion());
	        libro.setPortada(libroDto.getPortada());

	        // Actualiza las relaciones con autor, editorial y categoría
	        libro.setAutor(autorRepository.findById(libroDto.getAutor()).orElse(null));
	        libro.setEditorial(editorialRepository.findById(libroDto.getEditorial()).orElse(null));
	        libro.setCategoria(categoriaRepository.findById(libroDto.getCategoria()).orElse(null));

	        // Guarda el libro actualizado en la base de datos
	        return libroRepository.save(libro);
	    } else {
	        throw new ResourceNotFoundException("Libro no encontrado con ID: " + id);
	    }
	}
	


	@Override
	public void delete(int id) {
	    libroRepository.deleteById(id);
	}

	@Override
	public Optional<Libro> read(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Libro> readAll() {
		// TODO Auto-generated method stub
	    return libroRepository.findAll();
	}
	
	
	
	
    public Libro guardarLibro(LibroDto libroDto) {
        Autor autor = autorRepository.findById(libroDto.getAutor())
                .orElseThrow(() -> new EntityNotFoundException("Autor not found"));
        
        Categoria categoria = categoriaRepository.findById(libroDto.getCategoria())
                .orElseThrow(() -> new EntityNotFoundException("Categoria not found"));
        
        Editorial editorial = editorialRepository.findById(libroDto.getEditorial())
                .orElseThrow(() -> new EntityNotFoundException("Editorial not found"));

        Libro libro = new Libro();
        libro.setTitulo(libroDto.getTitulo());
        libro.setFechalan(libroDto.getFechalan());
        libro.setIdioma(libroDto.getIdioma());
        libro.setPaginas(libroDto.getPaginas());
        libro.setDescripcion(libroDto.getDescripcion());
        libro.setPortada(libroDto.getPortada());

        libro.setAutor(autor);
        libro.setCategoria(categoria);
        libro.setEditorial(editorial);
        
        return libroRepository.save(libro);
    }
}