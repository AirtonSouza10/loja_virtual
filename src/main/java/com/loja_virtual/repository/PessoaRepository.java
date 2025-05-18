package com.loja_virtual.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loja_virtual.model.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
}
