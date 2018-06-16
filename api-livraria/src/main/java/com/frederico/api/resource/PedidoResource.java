package com.frederico.api.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frederico.api.model.Item;
import com.frederico.api.model.Livro;
import com.frederico.api.model.Pedido;

@RestController
@RequestMapping("/v1/public/pedidos")
public class PedidoResource {

	// Realiza pedido do carrinho vinculado a SessionID
	@PostMapping("/{session_id}")
	public String realizaPedido(@PathVariable String session_id) {
		return "Pedido realizado com sucesso para SessionId: " + session_id
				+ ". Seu pedido é o nº: 342342634645";
	}
	
	// Consulta status do pedido
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
	
}
