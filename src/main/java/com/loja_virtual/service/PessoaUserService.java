package com.loja_virtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_virtual.repository.UsuarioRepository;

@Service
public class PessoaUserService {
	@Autowired
	private UsuarioRepository usuarioRepository;
}
