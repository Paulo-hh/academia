package com.example.academia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.academia.model.Aluno;
import com.example.academia.repositories.AlunoRepository;

import jakarta.validation.Valid;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping("/inserirAlunos")
	public ModelAndView insertAlunos(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/formAluno");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@PostMapping("InsertAlunos")
	public ModelAndView inserirAluno(@Valid Aluno aluno, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("Aluno/formAluno");
			mv.addObject("aluno");
		}
		else {
			mv.setViewName("redirect:/alunos-adicionados");
			alunoRepository.save(aluno);
		}
		return mv;
	}
	
	@GetMapping("alunos-adicionados")
	public ModelAndView listagemAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/listAlunos");
		mv.addObject("alunosList", alunoRepository.findAll());
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/alterar");
		Aluno aluno = alunoRepository.findById(id).get();
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		alunoRepository.save(aluno);
		mv.setViewName("redirect:/alunos-adicionados");
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirAluno(@PathVariable Integer id) {
		alunoRepository.deleteById(id);
		return "redirect:/alunos-adicionados";
	}
	
	@GetMapping("filtro-alunos")
	public ModelAndView filtroAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/filtroAlunos");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@GetMapping("alunos-ativos")
	public ModelAndView listaAlunosAtivos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/alunos-ativos");
		mv.addObject("alunosAtivos", alunoRepository.findByStatusAtivos());
		return mv;
	}
	
	@GetMapping("alunos-inativos")
	public ModelAndView listaAlunosInativos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/alunos-inativos");
		mv.addObject("alunosInativos", alunoRepository.findByStatusInativos());
		return mv;
	}
	
	@GetMapping("alunos-cancelados")
	public ModelAndView listaAlunosCancelados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/alunos-cancelados");
		mv.addObject("alunosCancelados", alunoRepository.findByStatusCancelados());
		return mv;
	}
	
	@GetMapping("alunos-trancados")
	public ModelAndView listaAlunosTrancados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/alunos-trancados");
		mv.addObject("alunosTrancados", alunoRepository.findByStatusTrancados());
		return mv;
	}
	
	@PostMapping("pesquisar-aluno")
	public ModelAndView pesquisarAluno(@RequestParam(required = false) String nome) {
		ModelAndView mv = new ModelAndView();
		List<Aluno> listaAlunos;
		if(nome == null || nome.trim().isEmpty()) {
			listaAlunos = alunoRepository.findAll();
		}
		else {
			listaAlunos = alunoRepository.findByNomeContainingIgnoreCase(nome);
		}
		mv.addObject("ListaDeAlunos", listaAlunos);
		mv.setViewName("Aluno/pesquisa-resultado");
		return mv;
	}
	
}
