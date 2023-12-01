package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               
@AllArgsConstructor 
@NoArgsConstructor  
public class AlquilerDto {

    private String fechasa;
    private String fechaen;
    private int lector;
    private int libro;


}
