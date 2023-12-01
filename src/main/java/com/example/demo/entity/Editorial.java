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
@Table(name="EDITORIALES")
public class Editorial {
	@Id
	@Column(name = "ID_EDITORIAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEditoriales")
    @SequenceGenerator(name = "seqEditoriales", allocationSize = 1, sequenceName = "SEQ_EDITORIALES")
    private Integer id;
	
	//  ---------------------------------------------------------------EDITORIAL DEL EDITORIAL----------------------    
	@Column(name = "EDITORIAL")
	@NotNull @NotBlank    
    private String nombreeditorial;
	//  ---------------------------------------------------------------AÑO DEL EDITORIAL----------------------    
	@Column(name = "AÑO")
	@NotNull @NotBlank    
    private String ano;
	//  ---------------------------------------------------------------DESCRIPCION DEL EDITORIAL--------------
	@Column(name = "DESCRIPCION")
	@NotNull @NotBlank    
    private String descripcion;
	//  ---------------------------------------------------------------SITIO_WEB DEL EDITORIAL-------------
	@Column(name = "SITIO_WEB")
	@NotNull @NotBlank    
    private String sitioweb;
	//  ---------------------------------------------------------------LUGAR_NACIMIENTO DEL EDITORIAL-------------


//TODO RELACIONES 	

		//----------RELACION DE EDITORIAL CON LIBRO----------
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "editorial")
		@JsonIgnore
		private Set<Libro> libros;

}