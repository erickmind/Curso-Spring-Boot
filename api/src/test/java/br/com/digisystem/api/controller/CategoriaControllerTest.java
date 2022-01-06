package br.com.digisystem.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.digisystem.api.model.Categoria;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoriaControllerTest {

	@Autowired
    private MockMvc mockMvc; // Simula uma requisicao REST

    @Autowired
    private ObjectMapper objectMapper; // Converte strings em objetos
    
    @Test
    void case1() throws Exception {

    	/* Requisição GET para a API*/
    	ResultActions response = mockMvc.perform(get("/categorias/1") // Pega o resultado da requisição nesse endpoint
                .contentType("application/json")
                .header("meu header", "valor do meu header") );
    	
    	/*Convertendo resposta para o obj Categoria*/
    	MvcResult result = response.andReturn(); // 
    	String contentAsString = result.getResponse().getContentAsString(); // Converte o resultado no formato de objeto MvcResult em uma String

    	Categoria cResponse = objectMapper.readValue(contentAsString, Categoria.class); // Transforma a String em um objeto do tipo Categoria
    	
    	/*Criando obj de teste*/
    	Categoria c1Test = Categoria.builder()
    			.id(1)
    			.nome("Categoria 1")
    			.descricao("É a categoria 1")
    			.build();

    	/*comparando o que vem da API com o que esperamos*/
        Assertions.assertEquals(c1Test, cResponse );
    }    
}