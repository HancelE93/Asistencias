package com.krakedev.asistencias.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.servicios.ServicioEstudiantes;


@RestController

@RequestMapping("/estudiantes")
public class ControladorEstudiantes {
	
	  private final ServicioEstudiantes serviciosEstudiantes;

	    public ControladorEstudiantes(ServicioEstudiantes serviciosEstudiantes) {
	        this.serviciosEstudiantes = serviciosEstudiantes;
	    }
	
	@PostMapping
	public Estudiante agregar(@RequestBody Estudiante estudiante) {
		
		return serviciosEstudiantes.agregar(estudiante);
	}
	
	@GetMapping("/{cedula}")
	public Estudiante buscar(@PathVariable String cedula) {
		return serviciosEstudiantes.buscarPorCedula(cedula);
	}
	
	
	@DeleteMapping("/{cedula}")
	public boolean eliminar(@PathVariable String cedula) {
		
		return serviciosEstudiantes.eliminar(cedula);
	}
	
	@PutMapping("/{cedula}")
	public Estudiante actualizar(@PathVariable String cedula, @RequestBody Estudiante actualizar) {
		return serviciosEstudiantes.actualizar(cedula, actualizar);
		
	}
	
	@GetMapping
	public List<Estudiante> lista(){
		return serviciosEstudiantes.listar();
	}

}
