package com.cadastrodeContatos.cadastroDeContatos.models;



import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;




//

	
	@Entity
	public class Pessoa implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		private long codigo;

		@NotNull
		@NotEmpty
		private String nome;
		
		@NotNull
		@NotEmpty
		private String dataNascimento;
		
		
		private String nacionalidade;

		
		private String naturalidade;
		
		private String cpf;
		@Email 	  
		private String email;

		public long getCodigo() {
			return codigo;
		}

		public void setCodigo(long codigo) {
			this.codigo = codigo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public String getNacionalidade() {
			return nacionalidade;
		}

		public void setNacionalidade(String nacionalidade) {
			this.nacionalidade = nacionalidade;
		}

		public String getNaturalidade() {
			return naturalidade;
		}

		public void setNaturalidade(String naturalidade) {
			this.naturalidade = naturalidade;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		

}
