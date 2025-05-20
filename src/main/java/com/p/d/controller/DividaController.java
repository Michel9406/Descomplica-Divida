package com.p.d.controller;


import com.p.d.model.Divida;
import com.p.d.repository.DividaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dividas")
public class DividaController {

    private final DividaRepository repository;

    public DividaController(DividaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Divida> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Divida criar(@RequestBody Divida divida) {
        return repository.save(divida);
    }

    @GetMapping("/{id}")
    public Divida buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Divida atualizar(@PathVariable Long id, @RequestBody Divida divida) {
        if (!repository.existsById(id)) return null;
        divida.setId(id);
        return repository.save(divida);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}