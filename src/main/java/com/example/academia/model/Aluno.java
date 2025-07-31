package com.example.academia.model;

import com.example.academia.Enums.Curso;
import com.example.academia.Enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Curso curso;
	
	private String matricula;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private String turno;
	
	public Aluno() {
	}

	public Aluno(Integer id, String nome, Curso curso, String matricula, Status status, String turno) {
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.matricula = matricula;
		this.status = status;
		this.turno = turno;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getTurno() {
		return turno;
	}
	
	public void setTurno(String turno) {
		this.turno = turno;
	}

}
