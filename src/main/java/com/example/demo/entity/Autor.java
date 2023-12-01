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
@Table(name="AUTORES")
public class Autor {
	@Id
	@Column(name = "ID_AUTOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAutores")
    @SequenceGenerator(name = "seqAutores", allocationSize = 1, sequenceName = "SEQ_AUTOR")
    private Integer id;
	
	//  ---------------------------------------------------------------NOMBRE DEL AUTOR----------------------    
	@Column(name = "AUTOR")
	@NotNull @NotBlank    
    private String nombreautor;
	//  ---------------------------------------------------------------APELLIDO_AUTOR DEL AUTOR--------------
	@Column(name = "APELLIDO_AUTOR")
	@NotNull @NotBlank    
    private String apellidosautor;
	//  ---------------------------------------------------------------FECHA_NACIMIENTO DEL AUTOR-------------
	@Column(name = "FECHA_NACIMIENTO")
	@NotNull @NotBlank    
    private String fecha_nacimiento;
	//  ---------------------------------------------------------------LUGAR_NACIMIENTO DEL AUTOR-------------
	@Column(name = "LUGAR_NACIMIENTO")
	@NotNull @NotBlank    
    private String lugar_nacimiento;
	//  ---------------------------------------------------------------GENERO DEL AUTOR-----------------------
	@Column(name = "GENERO")
	@NotNull @NotBlank    
    private String genero;

								//TODO RELACIONES 	
	
		//----------RELACION DE AUTOR CON LIBRO----------
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "autor")
		@JsonIgnore
		private Set<Libro> libros;

}
