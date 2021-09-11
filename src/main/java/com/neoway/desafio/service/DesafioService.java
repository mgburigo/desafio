package com.neoway.desafio.service;

import com.neoway.desafio.model.Cliente;
import com.neoway.desafio.repository.DesafioRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.Normalizer;


@Service
public class DesafioService {

    private final static int INICIO_COLUNA1 = 0;
    private final static int FIM_COLUNA1 = 18;

    private final static int INICIO_COLUNA2 = 19;
    private final static int FIM_COLUNA2 = 30;

    private final static int INICIO_COLUNA3 = 31;
    private final static int FIM_COLUNA3 = 42;

    private final static int INICIO_COLUNA4 = 43;
    private final static int FIM_COLUNA4 = 64;

    private final static int INICIO_COLUNA5 = 65;
    private final static int FIM_COLUNA5 = 86;

    private final static int INICIO_COLUNA6 = 87;
    private final static int FIM_COLUNA6 = 110;

    private final static int INICIO_COLUNA7 = 111;
    private final static int FIM_COLUNA7 = 130;

    private final static int INICIO_COLUNA8 = 131;
    private final static int FIM_COLUNA8 = 152;


    @Autowired
    DesafioRepository desafioRepository;

    public void processaLinha(String linha) {
        
        Cliente cliente = new Cliente();
        
        cliente.setCpf(linha.substring(INICIO_COLUNA1, FIM_COLUNA1));
        cliente.setPrivado(linha.substring(INICIO_COLUNA2,FIM_COLUNA2));
        cliente.setIncompleto(linha.substring(INICIO_COLUNA3,FIM_COLUNA3));
        cliente.setDataUltimaCompra(linha.substring(INICIO_COLUNA4,FIM_COLUNA4));
        cliente.setTicketMedio(linha.substring(INICIO_COLUNA5,FIM_COLUNA5));
        cliente.setTicketUltimaCompra(linha.substring(INICIO_COLUNA6,FIM_COLUNA6));
        cliente.setLojaMaisFrequente(linha.substring(INICIO_COLUNA7,FIM_COLUNA7));
        cliente.setLojaUltimaCompra(linha.substring(INICIO_COLUNA8));
        
        desafioRepository.save(cliente);
    }


    public static String removerAcentos(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[^\\p{ASCII}]", "");
        return texto;
    }

    public void higienizaDados() {

        int pages = 0;
        int limit = 1000;

        boolean hasPending = true;

        while (hasPending) {

            Pageable paging = PageRequest.of(pages, limit, Sort.by("id").ascending());

            Page<Cliente> clientesList = desafioRepository.findAll(paging);

            hasPending = clientesList.getTotalPages() > pages;

            for (Cliente client : clientesList) {
                System.out.println(client.getCpf().trim().toUpperCase());
                client.setCpf(client.getCpf().trim().toUpperCase());
                if (client.getCpf().matches("(^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$)")) {
                    client.setCpfValido(Boolean.TRUE);
                } else {
                    client.setCpfValido(Boolean.FALSE);
                }
                client.setPrivado(client.getPrivado().trim());
                client.setIncompleto(client.getIncompleto().trim());

                client.setDataUltimaCompra(removerAcentos(client.getDataUltimaCompra().trim().toUpperCase()));
                if ("NULL".equals(client.getDataUltimaCompra()) || Strings.isEmpty(client.getDataUltimaCompra())) {
                    client.setDataUltimaCompra("");
                }

                client.setTicketMedio(removerAcentos(client.getTicketMedio().trim().toUpperCase()));
                if ("NULL".equals(client.getTicketMedio()) || Strings.isEmpty(client.getTicketMedio())) {
                    client.setTicketMedio("");
                }

                client.setTicketUltimaCompra(removerAcentos(client.getTicketUltimaCompra().trim().toUpperCase()));
                if ("NULL".equals(client.getTicketUltimaCompra()) || Strings.isEmpty(client.getTicketUltimaCompra())) {
                    client.setTicketUltimaCompra("");
                }

                client.setLojaMaisFrequente(removerAcentos(client.getLojaMaisFrequente().trim().toUpperCase()));
                if ("NULL".equals(client.getLojaMaisFrequente()) || Strings.isEmpty(client.getLojaMaisFrequente())) {
                    client.setLojaMaisFrequente("");
                } else {
                    if (client.getLojaMaisFrequente().matches("(^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$)")) {
                        client.setCnpjValido(Boolean.TRUE);
                    } else {
                        client.setCnpjValido(Boolean.FALSE);
                    }
                }

                client.setLojaUltimaCompra(removerAcentos(client.getLojaUltimaCompra().trim().toUpperCase()));
                if ("NULL".equals(client.getLojaUltimaCompra()) || Strings.isEmpty(client.getLojaUltimaCompra())) {
                    client.setLojaUltimaCompra("");
                } else {
                    if (client.getLojaUltimaCompra().matches("(^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$)")) {
                        client.setCnpjValido(Boolean.TRUE);
                    } else {
                        client.setCnpjValido(Boolean.FALSE);
                    }
                }

                desafioRepository.save(client);
            }

            pages += 1;
        }

    }

    public void removeTodosDados() {
        desafioRepository.deleteAll();
    }
}
