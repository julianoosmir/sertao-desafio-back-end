package org.example.sertaodesafio.controllers;

import org.example.sertaodesafio.entity.Produto;
import org.example.sertaodesafio.interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private IProdutoService produtoService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<Produto> listar() {
        return this.produtoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public Produto findById(@PathVariable Long id) {
        return this.produtoService.findById(id);
    }
    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public Produto save(@RequestBody Produto produto) {
        return this.produtoService.save(produto);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Produto update(@RequestBody Produto produto) {
        return this.produtoService.save(produto);
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@RequestBody Produto produto) {
        this.produtoService.delete(produto.getId());
    }
}
