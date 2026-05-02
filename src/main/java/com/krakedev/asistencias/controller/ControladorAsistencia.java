package com.krakedev.asistencias.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.RegistroAsistencia;
import com.krakedev.asistencias.servicios.ServicioAsistencia;


@RestController

@RequestMapping("/asistencias")
public class ControladorAsistencia {
	
	private final ServicioAsistencia serviciosAsistencia;
	
	public ControladorAsistencia(ServicioAsistencia serviciosAsistencia) {
	    this.serviciosAsistencia = serviciosAsistencia;
	}
	
	@PostMapping("/{cedula}")
	public RegistroAsistencia registrar(@PathVariable String cedula) {
	    return serviciosAsistencia.registrarAsistencia(cedula);
	}
	
	
	@GetMapping("/{cedula}")
	public ArrayList<Asistencia> lista(@PathVariable String cedula) {
	    return serviciosAsistencia.consultarAsistencia(cedula);
	}

}
