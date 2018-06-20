package com.frederico.api.resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.frederico.api.model.Autenticacao;
import com.frederico.api.model.DadosPagamento;
import com.frederico.api.model.Item;
import com.frederico.api.model.Livro;
import com.frederico.api.model.Pagamento;
import com.frederico.api.model.Pedido;

@RestController
@RequestMapping("/v1/public/pedidos")
public class PedidoResource {

	// Realizar pedido
	@PostMapping("/{carrinho_id}")
	public String realizaPedido(@PathVariable Long carrinho_id, @RequestBody Pagamento pagamento) {
		
		// Realizar autenticação
		Boolean response = autenticar(new Autenticacao(pagamento.getUsuario(), pagamento.getSenha()));
		  
		if (response.booleanValue() == true) {
			  
			// Realizar pagamento
			Boolean pagamentoRealizado = realizarPagamento(pagamento.getUsuario()
					, pagamento.getNumeroCartaoCreditor(), new Float(265.00));
			
			if (pagamentoRealizado.booleanValue() == false) {
				return "Não foi possível realizar o pagamento. Cartão de "
						+ "crédito inválido.";
			}
			
			return "Pedido realizado com sucesso. Seu pedido é o nº: 737351008735";
		}else {
			return "Usuário não autorizado.";
		}
		
	}
	
	// Consultar status do pedido
	@GetMapping("/{id_pedido}")
	public Pedido consultaStatusPedido(@PathVariable Long id_pedido) {
		
		Pedido pedido = new Pedido(id_pedido);
		Item item_1 = new Item(new Long(86), new Livro(new Long(12),"Historia do mundo"
				, "Jose", "912-4-12-3465623-7", new Float(214.00)));
		Item item_2 = new Item(new Long(63), new Livro(new Long(12),"Historia da ciencia"
				, "Fulano", "123-135-123-2354365-1", new Float(124.12)));
		Item item_3 = new Item(new Long(14), new Livro(new Long(12),"Historia da Tecnologia"
				, "Ciclano", "14-25-235-3462-2", new Float(153.56)));
		
		pedido.getItens().add(item_1);
		pedido.getItens().add(item_2);
		pedido.getItens().add(item_3);
		
		return pedido;
		
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
	
	private Boolean realizarPagamento(String usuario, String numeroCartao, Float valorDebito ) {
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	    headers.setContentType(MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<DadosPagamento> requestBody = new HttpEntity<>(new DadosPagamento(
				usuario, numeroCartao, valorDebito),headers);
		
		  Boolean response = restTemplate.postForObject("http://localhost:8082/v1/public/transacao",
				  requestBody, Boolean.class);
		  
		  return response;
	}
	
}
