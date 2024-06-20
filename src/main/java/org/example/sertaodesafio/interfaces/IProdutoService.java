package org.example.sertaodesafio.interfaces;

import org.example.sertaodesafio.entity.Produto;

import java.util.List;

public interface IProdutoService {
    List<Produto> findAll();
    Produto findById(Long id);
    Produto save(Produto produto);
    void delete(Long id);
}
