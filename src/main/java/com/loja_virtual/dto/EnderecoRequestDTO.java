package com.loja_virtual.dto;

import com.loja_virtual.enums.TipoEndereco;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EnderecoRequestDTO {
	private Long id;
	private String rua;
	private String logradouro;
	private String cep;
	private String numero;
	private String complemento;
	private String bairro;
	private String uf;
	private String cidade;
	private TipoEndereco tipoEndereco;
}
