package com.example.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="LIBROS")
public class Libro {
	@Id
	@Column(name = "ID_LIBRO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLibros")
    @SequenceGenerator(name = "seqLibros", allocationSize = 1, sequenceName = "SEQ_LIBRO")
    private Integer id;
	
	
	//atributos
	
	@Column(name = "TITULO")  
	@NotNull @NotBlank    
    private String titulo;
	
	@Column(name = "FECHA_LANZAMIENTO")	
	@NotNull @NotBlank    
    private String fechalan;
	
	@Column(name = "IDIOMA")  
	@NotNull @NotBlank    
    private String idioma;

	@Column(name = "PAGINAS")   
	@NotNull @NotBlank    
    private String paginas;
	
	@Column(name = "DESCRIPCION")   
	@NotNull @NotBlank    
    private String descripcion;
	
	@Column(name = "PORTADA")   
	@NotNull @NotBlank    
    private String portada;
	
	
//TODO RELACIONES  FORANEAS	
	
		//----------RELACION DE LIBRO CON AUTOR---------------
		@ManyToOne
		@JoinColumn(name="AUTOR_ID", nullable = false)
		private Autor autor;
		
		//----------RELACION DE LIBRO CON CATEGORIA-----------
		@ManyToOne
		@JoinColumn(name="CATEGORIA_ID", nullable = false)
		private Categoria categoria;
		
		//----------RELACION DE LIBRO CON EDITORIAL-----------
		@ManyToOne
		@JoinColumn(name="EDITORIAL_ID", nullable = false)
		private Editorial editorial;
		
		//----------RELACION DE LIBRO CON ALQUILERES----------
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "libro")
		@JsonIgnore
		private Set<Alquiler> alquileres;
}

