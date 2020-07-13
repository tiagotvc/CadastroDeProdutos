package com.cadastrodeContatos.cadastroDeContatos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cadastrodeContatos.cadastroDeContatos.models.Pessoa;
import com.cadastrodeContatos.cadastroDeContatos.repository.PessoaRepository;




@Controller
public class PessoaController {
	
	
	@Autowired
	private PessoaRepository pr;
	
	@RequestMapping(value="/cadastrarContatos", method=RequestMethod.GET)
	public String form(){
		return "pessoa/formPessoa";
}
	
	@RequestMapping(value="/cadastrarContatos", method=RequestMethod.POST)
	public String form(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attributes){
	    if(result.hasErrors()) {
	    	attributes.addFlashAttribute("mensagem","Campos Obrigatórios: Nome, Data de Nascimento!");
	    	attributes.addFlashAttribute("mensagem1","Campo Email precisa estar no formato correto");
	    	
	    	
	    	return "redirect:/cadastrarContatos";
	      }
		    pr.save(pessoa);
		    attributes.addFlashAttribute("mensagem","Contato Gravado com Sucesso!");
		    return "redirect:/cadastrarContatos";
}

	
	@RequestMapping("/pessoas")
	public ModelAndView listaContatos(){
		ModelAndView mv = new ModelAndView("listaContatos");
		Iterable<Pessoa> pessoas = pr.findAll();
		mv.addObject("pessoas", pessoas);
		return mv;
}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView atualizarPessoa(@PathVariable("codigo") long codigo){
		Pessoa pessoa = pr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("pessoa/atualizarContato");
		mv.addObject("pessoa", pessoa);
		return mv;
		
	}
	
	
	@RequestMapping("/edit/{codigo}")
	public ModelAndView atalizarPessoa1(@PathVariable(name = "codigo") long codigo) {
	    ModelAndView mv = new ModelAndView("pessoa/atualizarContato");
	    Pessoa pessoa = pr.findByCodigo(codigo);
	    mv.addObject("pessoa", pessoa);
	     
	    return mv;
	}

	
	
	@RequestMapping("/deletarPessoa")
	public String deletarPessoa(long codigo){
		Pessoa pessoa = pr.findByCodigo(codigo);
		pr.delete(pessoa);
		return "redirect:/pessoas";
	}
	
	
	
}
