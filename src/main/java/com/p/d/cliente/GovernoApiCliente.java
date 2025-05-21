package com.p.d.cliente;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Component
public class GovernoApiCliente {

    private final RestTemplate restTemplate = new RestTemplate();

    public String consultarDividasPorDocumento(String documento) {
        String url = "https://api.gov.br/dividas?documento=" + documento;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response.getBody();
    }
}