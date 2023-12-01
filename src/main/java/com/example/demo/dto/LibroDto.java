package com.example.demo.dto;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data               
@AllArgsConstructor 
@NoArgsConstructor  

public class LibroDto {
	
	// Un campo que representa los  atributos de libro.{
	
	//atributos
    private String titulo;
    	private String fechalan;
    		private String idioma;
    			private String paginas;
    				private String descripcion;
    					private String portada;
	
	//foraneas
		private int autor ;
			private int editorial;
				private int categoria;

}
//TODO:APUNTES DE MARK
//se utiliza para transferir datos relacionados con un convenio
//desde el cliente TODO(aplicación Angular) al servidor  TODO(controlador de Spring Boot).