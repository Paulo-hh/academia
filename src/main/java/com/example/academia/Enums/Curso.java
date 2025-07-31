package com.example.academia.Enums;

public enum Curso {
	
	ADMINISTRACAO("Administracao"),
	COMPUTACAO("Computacao"),
	CONTABILIDADE("Contabilidade"),
	ECONOMIA("Economia"),
	ENFERMAGEM("Enfermagem");
	
	private String curso;
	
	private Curso(String curso) {
		this.curso = curso;
	}
	
}
