package com.krakedev.asistencias;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProbandoAsistencia {
	
	@GetMapping("/hola")
	public String saludar() {
		return "Hola desde Spring Boot";
	}

}
