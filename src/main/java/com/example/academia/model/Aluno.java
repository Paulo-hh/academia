package com.example.academia.model;

import com.example.academia.Enums.Curso;
import com.example.academia.Enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(min = 5, max = 35, message = "O nome deve conter no mínimo 5 caracteres")
	@NotBlank(message = "O nome não pode ser vazio.")
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo curso não pode ser nulo.")
	private Curso curso;
	
	@NotNull(message = "Clique no botão Gerar!")
	@Size(min = 3, message = "Clique no botão gerar matricula!")
	private String matricula;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo status não pode ser nulo.")
	private Status status;
	
	@NotBlank(message = "O turno não pode ser vazio.")
	@Size(min = 4, message = "No minimo 4 caracteres.")
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
