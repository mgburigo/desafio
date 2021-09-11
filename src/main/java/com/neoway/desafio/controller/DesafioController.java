package com.neoway.desafio.controller;

import com.neoway.desafio.service.DesafioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("desafio/importador")
public class DesafioController {

    @Autowired
    DesafioService desafioService;

    @PostMapping(value = "/execute")
    public String execute() {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = loader.getResourceAsStream("file/base_teste2.txt");

        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        String retorno = "";

        try (BufferedReader bufferedReader = new BufferedReader(reader)){

            String linha = bufferedReader.readLine();

            while (linha != null) {

                desafioService.processaLinha(linha);

                System.out.println(linha);
                linha = bufferedReader.readLine();

            }

            retorno = "Arquivo Importado com sucesso!";

        } catch (IOException e) {
            e.printStackTrace();
            retorno = "Erro ao importar o arquivo";
        }

        return retorno;

    }

    @PostMapping(value = "/higieniza")
    public String higieniza() {

        desafioService.higienizaDados();

        return "ok";

    }

    @DeleteMapping(value = "/removeAll")
    public String remove() {

        desafioService.removeTodosDados();

        return "ok";

    }

}
