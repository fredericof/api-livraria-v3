package com.frederico.api.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frederico.api.model.Comentario;
import com.frederico.api.model.Comentarios;
import com.frederico.api.model.Livro;
import com.frederico.api.model.LivroPaginacao;

@RestController
@RequestMapping("/v1/public/livros")
public class LivroResource {
	
	// Busca todos os livros
	@GetMapping()
	public LivroPaginacao buscarLivros() {

		List<Livro> livros = new ArrayList<Livro>();

		Livro livro_1 = new Livro(new Long(1), "Livro 1", "Jose", "978-3-23-129746-1", new Float(200.00));
		Livro livro_2 = new Livro(new Long(2), "Livro 2", "João", "124-3-16-148410-2", new Float(345.00));
		Livro livro_3 = new Livro(new Long(3), "Livro 3", "Maria", "235-3-16-926478-3", new Float(123.123));
		Livro livro_4 = new Livro(new Long(4), "Livro 4", "Carlos", "163-3-13-123246-4", new Float(64.15));
		Livro livro_5 = new Livro(new Long(5), "Livro 5", "Frederico", "157-3-36-143510-5", new Float(33.21));
		Livro livro_6 = new Livro(new Long(6), "Livro 6", "Frederico", "435-4-46-934568-6", new Float(12.35));
		
		livros.add(livro_1);
		livros.add(livro_2);
		livros.add(livro_3);
		livros.add(livro_4);
		livros.add(livro_5);
		livros.add(livro_6);
		
		return new LivroPaginacao(livros);
	}
	
	// Busca livro especifico por id
	@GetMapping("/{id_livro}")
	public Livro buscarPeloId(@PathVariable Long id_livro) {
		Livro livro = new Livro(id_livro, "Uma viagem", "Jose", "978-3-23-129746-1", new Float(200.00));
		
		return livro;
	}
	
	// Busca livros relacionado ao nome do autor
	@GetMapping("/autor/{nome_autor}")
	public LivroPaginacao buscarPorAutor(@PathVariable String nome_autor) {
		LivroPaginacao livrosPaginacao = new LivroPaginacao();
		
		livrosPaginacao.getLivros().add(new Livro(new Long(12), "Relogio"
				, nome_autor, "912-4-12-3465623-2", new Float(200.00)));
		livrosPaginacao.getLivros().add(new Livro(new Long(45), "Historia"
				, nome_autor, "478-3-46-2344325-1", new Float(214.67)));
		livrosPaginacao.getLivros().add(new Livro(new Long(11), "Eistein"
				, nome_autor, "618-2-23-2321112-6", new Float(235.46)));
		livrosPaginacao.getLivros().add(new Livro(new Long(57), "Como funciona"
				, nome_autor, "128-1-76-6672344-3", new Float(123.44)));
		
		return livrosPaginacao;
	}
	
	// Busca livro pelo código isbn
	@GetMapping("/isbn/{codigo_isbn}")
	public LivroPaginacao buscarPorIsbn(@PathVariable String codigo_isbn) {
		LivroPaginacao livrosPaginacao = new LivroPaginacao();
		
		livrosPaginacao.getLivros().add(new Livro(new Long(57), "Programacao"
				, "Ciclano", codigo_isbn, new Float(123.04)));
		
		return livrosPaginacao;
	}
	
	// Busca livros relacionado ao titulo
	@GetMapping("/titulo/{titulo}")
	public LivroPaginacao buscarPorTitulo(@PathVariable String titulo) {
		LivroPaginacao livrosPaginacao = new LivroPaginacao();
		
		livrosPaginacao.getLivros().add(new Livro(new Long(12), titulo + " historia"
				, "Jose", "912-4-12-3465623-2", new Float(100.00)));
		livrosPaginacao.getLivros().add(new Livro(new Long(45), titulo + " matematica"
				, "Maria", "478-3-46-2344325-1", new Float(300.00)));
		livrosPaginacao.getLivros().add(new Livro(new Long(11), titulo
				, "Fulano", "618-2-23-2321112-6", new Float(100.23)));
		livrosPaginacao.getLivros().add(new Livro(new Long(57), titulo + " portugues"
				, "Ciclano", "128-1-76-6672344-3", new Float(20.023)));
		
		return livrosPaginacao;
	}
	
	// Busca comentarios de um livro especifico
	@GetMapping("/{id_livro}/comentarios")
	public Comentarios buscarComentariosLivro(@PathVariable Long id_livro) {
		return new Comentarios();
	}
	
	// Adiciona comentario a um livro especifico
	@PostMapping("/{id_livro}/comentarios")
	public String adicionaComentarioLivro(@PathVariable Long id_livro, @RequestBody Comentario comentario) {
		
		return "Comentario '" + comentario.getComentario() + "' adicionado com sucesso!";
	}
	
}
