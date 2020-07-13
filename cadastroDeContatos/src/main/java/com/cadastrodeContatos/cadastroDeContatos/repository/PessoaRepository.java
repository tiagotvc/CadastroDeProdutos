package com.cadastrodeContatos.cadastroDeContatos.repository;

import org.springframework.data.repository.CrudRepository;

import com.cadastrodeContatos.cadastroDeContatos.models.Pessoa;



public interface PessoaRepository extends CrudRepository<Pessoa, String>{
	Pessoa findByCodigo(long codigo);
}