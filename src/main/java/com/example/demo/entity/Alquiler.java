package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="ALQUILERES")
public class Alquiler {
	
	@Id
	@Column(name = "ID_ALQUILER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAlquiler")
    @SequenceGenerator(name = "seqAlquiler", allocationSize = 1, sequenceName = "SEQ_ALQUILERES")
    private Integer id;
	
	@Column(name = "FECHA_SALIDA")	
	@NotBlank @NotNull
    private String fechasa;
	
	@Column(name = "FECHA_ENTRADA")	
	@NotBlank @NotNull          
    private String fechaen;
	
	
//TODO RELACIONES 	
	
		//RELACION DE ALQUILERES CON LIBRO
		@ManyToOne
		@JoinColumn(name="LIBRO_ID", nullable = false)
		private Libro libro;
		
		//RELACION DE ALQUILERES CON AUTOR
		@ManyToOne
		@JoinColumn(name="LECTOR_ID", nullable = false)
		private Lector lector;

}