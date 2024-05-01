package com.loja_virtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.loja_virtual.controller.AcessoController;
import com.loja_virtual.model.Acesso;
import com.loja_virtual.service.AcessoService;

@SpringBootTest(classes = LojaVirtualApplication.class)
class LojaVirtualApplicationTests {
	
	@Autowired
	private AcessoService acessoServie;
	@Autowired
	private AcessoController acessoController;

	@Test
	void testCadastraAcesso() {
		var acesso = new Acesso(null, "ROLE_ADMIN");
		acessoServie.save(acesso);
	}
	
	@Test
	void testCadastraAcessoController() {
		var acesso = new Acesso(null, "ROLE_ADMIN");
		acessoController.salvarAcesso(acesso);
	}

}
