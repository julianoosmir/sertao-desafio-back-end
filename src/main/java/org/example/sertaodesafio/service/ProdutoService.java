package org.example.sertaodesafio.service;

import org.example.sertaodesafio.entity.Produto;
import org.example.sertaodesafio.interfaces.IProdutoService;
import org.example.sertaodesafio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
