package com.frederico.api.resource;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frederico.api.model.Livro;

@RestController
@RequestMapping("/v1/private/livros")
public class LivroPrivateResource {
	
	@PostMapping()
	public String cadastrarLivros(@RequestBody List<Livro> livros) {
		
		return "Livro(s) cadastrado(s) com sucesso!";
	}

}
