package com.frederico.api.resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		
		return "Foi adicionado " + quantidade.getQuantidade() + " item(s) com sucesso!";
	}
	
	// Deleta item do carrinho vinculado a SessionID
	@DeleteMapping("/{session_id}")
	public String deletaItemCarrinho(@PathVariable String session_id,  @RequestBody Quantidade quantidade) {
		return "Foi removido " + quantidade.getQuantidade() + " item(s) com sucesso!";
	}

}
