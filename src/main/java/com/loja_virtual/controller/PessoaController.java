package com.loja_virtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loja_virtual.ExceptionLojaVirtual;
import com.loja_virtual.dto.PessoaJuridicaRequestDTO;
import com.loja_virtual.dto.PessoaJuridicaResponseDTO;
import com.loja_virtual.service.PessoaUserService;

@RestController
public class PessoaController {
	
	@Autowired
	private PessoaUserService pessoaUserService;
	
	@ResponseBody
	@PostMapping(value = "**/salvar-pessoa-juridica")
	public ResponseEntity<PessoaJuridicaResponseDTO> salvarPessoaJuridica(@RequestBody PessoaJuridicaRequestDTO pessoaJuridica) throws ExceptionLojaVirtual{
		var pessoaJuridicaReponse = pessoaUserService.salvarPessoaJuridica(pessoaJuridica);
		return new ResponseEntity<PessoaJuridicaResponseDTO>(pessoaJuridicaReponse, HttpStatus.OK);
	}

}
