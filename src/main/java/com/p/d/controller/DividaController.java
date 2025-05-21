package com.p.d.controller;

import com.p.d.dto.ConsultaRequest;
import com.p.d.dto.ConsultaResponse;
import com.p.d.service.DividaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@CrossOrigin("*")
public class DividaController {

    @Autowired
    private DividaService service;

    @PostMapping
    public List<ConsultaResponse> consultarDividas(@RequestBody ConsultaRequest request) {
        return service.consultarDividas(request.getDocumento());
    }
}