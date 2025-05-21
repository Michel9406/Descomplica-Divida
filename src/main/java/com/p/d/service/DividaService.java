package com.p.d.service;

import com.p.d.cliente.GovernoApiCliente;
import com.p.d.model.Divida;
import com.p.d.repository.DividaRepository;
import com.p.d.dto.ConsultaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DividaService {

    @Autowired
    private DividaRepository repository;

    @Autowired
    private GovernoApiCliente governoApiClient;

    private boolean validarDocumento(String documento) {
        return documento != null && (documento.matches("[0-9]{11}") || documento.matches("[0-9]{14}"));
    }

    public List<ConsultaResponse> consultarDividas(String documento) {
        if (!validarDocumento(documento)) {
            throw new IllegalArgumentException("Documento inválido. Informe um CPF ou CNPJ válido.");
        }

        // Aqui para integrar API:
        
        String respostaAPI = governoApiClient.consultarDividasPorDocumento(documento);
        System.out.println("🔗 Resposta da API do Governo (simulada): " + respostaAPI);

        List<Divida> dividas = repository.findByDocumento(documento);

        if (dividas.isEmpty()) {
            throw new RuntimeException("Nenhuma dívida encontrada para o documento fornecido.");
        }

        return dividas.stream().map(divida -> {
            ConsultaResponse response = new ConsultaResponse();
            response.setDescricao(divida.getDescricao());
            response.setValor(divida.getValor());
            response.setDataVencimento(divida.getDataVencimento());
            response.setPaga(divida.isPaga());
            return response;
        }).collect(Collectors.toList());
    }
}