package com.loja_virtual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.web.context.WebApplicationContext;

import com.loja_virtual.controller.AcessoController;
import com.loja_virtual.model.Acesso;
import com.loja_virtual.service.AcessoService;

import junit.framework.TestCase;

@Profile("test")
@SpringBootTest(classes = LojaVirtualApplication.class)
class LojaVirtualApplicationTests extends TestCase {

	@Autowired
	private AcessoService acessoServie;
	@Autowired
	private AcessoController acessoController;
	@Autowired
	private WebApplicationContext webapp;

	@Test
	@Order(1)
	void testCadastraAcesso() {
		var acesso = new Acesso(null, "ROLE_ADMIN");
		acesso = acessoServie.save(acesso);

		Assertions.assertNotNull(acesso.getId());
	}

	@Test
	@Order(2)
	void testCadastraAcessoController() {
		var acesso = new Acesso(null, "ROLE_ADMIN");
		acesso = acessoController.salvarAcesso(acesso).getBody();

		Assertions.assertEquals("ROLE_ADMIN", acesso.getDescricao());
	}

	@Test
	@Order(3)
	void testDeletarAcessoController() {
		var acesso = new Acesso(null, "ROLE_ADMIN");
		acessoController.deletarAcesso(acesso);
	}
}
