package com.krakedev.asistencias.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;

@Service
public class ServicioAsistencia {

	private ArrayList<RegistroAsistencia> registros = new ArrayList<>();
	
	private final ServicioEstudiantes servicioEstudiantes;

	public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}

	public RegistroAsistencia registrarAsistencia(String cedula) {
			//Buscar estudiante por cedula, en servicioEstudiantes
			// si no existe el estudiante retorna null
			//crea la asistencia, con la fecha y hora actuales
		
		Estudiante existente = servicioEstudiantes.buscarPorCedula(cedula);

		if (existente == null) {
			return null;
		}	
			Asistencia asistencia = new Asistencia(
			LocalDate.now(),
			LocalDateTime.now(),
			"P"
			);
			//crea un registro asistencia, agrega a la lista, retorna elregistro creado
			
			RegistroAsistencia registro = new RegistroAsistencia(existente, asistencia);

		    registros.add(registro);

		    return registro;
			}

	public ArrayList<Asistencia> consultarAsistencia(String cedula) {
		// retorna todas las asistencias del estudiante
		
	    ArrayList<Asistencia> resultado = new ArrayList<>();

	    // recorrer todos los registros
	    for (RegistroAsistencia r : registros) {

	        // verificar si la cédula coincide
	        if (r.getEstudiante().getCedula().equals(cedula)) {

	            // agregar la asistencia a la lista
	            resultado.add(r.getAsistencia());
	        }
	    }

	    // retornar todas las asistencias encontradas
	    return resultado;
		
	}
}
