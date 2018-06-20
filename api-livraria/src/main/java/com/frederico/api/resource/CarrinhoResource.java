package com.frederico.api.resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.frederico.api.model.Autenticacao;
import com.frederico.api.model.Carrinho;
import com.frederico.api.model.Item;
import com.frederico.api.model.Livro;
import com.frederico.api.model.Quantidade;

@RestController
@RequestMapping("/v1/public/carrinho")
public class CarrinhoResource {
	
	// Consulta carrinho vinculado a SessionID
	@GetMapping("/{carrinho_id}")
	public Carrinho consultaCarrinho(@PathVariable Long carrinho_id) {
		Carrinho carrinho = new Carrinho(carrinho_id);
		
		carrinho.getItens().add(new Item(new Long(3), new Livro(new Long(12), "Estudo da informação"
				, "Jose", "912-4-12-3465623-2", new Float(200.00))));
		carrinho.getItens().add(new Item(new Long(1), new Livro(new Long(12), "Estudo da historia"
				, "Fulano", "123-4-12-3123123-3", new Float(234.20))));
		
		return carrinho;
	}
	
	// Adiciona item ao carrinho vinculado a SessionID
	@PutMapping("/{session_id}")
	public String adicionaItemCarrinho(@PathVariable String session_id, @RequestBody Quantidade quantidade) {
		
		Boolean autenticado = autenticar(new Autenticacao(quantidade.getUsuario(), quantidade.getSenha()));
		
		if (autenticado.booleanValue() == true) {
			return "Foi adicionado " + quantidade.getQuantidade() + " item(s) com sucesso!";
		} else {
			return "Usuário não autenticado!";
		}
	}
	
	// Deleta item do carrinho vinculado a SessionID
	@DeleteMapping("/{session_id}")
	public String deletaItemCarrinho(@PathVariable String session_id,  @RequestBody Quantidade quantidade) {
		
		Boolean autenticado = autenticar(new Autenticacao(quantidade.getUsuario(), quantidade.getSenha()));
		
		if (autenticado.booleanValue() == true) {
			return "Foi removido " + quantidade.getQuantidade() + " item(s) com sucesso!";
		} else {
			return "Usuário não autenticado!";
		}
	}
	
	private Boolean autenticar(Autenticacao autenticacao) {
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	    headers.setContentType(MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Autenticacao> requestBody = new HttpEntity<>(new Autenticacao(
				autenticacao.getUsuario(), autenticacao.getSenha()),headers);
		
		  Boolean response = restTemplate.postForObject("http://localhost:8081/v1/public/autenticacao",
				  requestBody, Boolean.class);
		  
		  return response;
	}

}
