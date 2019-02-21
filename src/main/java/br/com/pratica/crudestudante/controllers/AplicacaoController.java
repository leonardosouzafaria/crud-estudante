package br.com.pratica.crudestudante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pratica.crudestudante.models.Estudante;
import br.com.pratica.crudestudante.models.Usuario;
import br.com.pratica.crudestudante.repositorys.EstudanteRepository;
import br.com.pratica.crudestudante.repositorys.UsuarioRepository;

@RestController
public class AplicacaoController {
	
	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@Autowired
	private UsuarioRepository usuarioRespository; 

	@GetMapping("/carga-inicial")
	public String enviarCargaInicial() {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Carlos Aberto");
		usuario.setSenha("1234");
		
		Estudante estudante = new Estudante();
		estudante.setNome("José da silva");
		estudante.setNumeroPassaporte("145W112");
		
		try {
			estudanteRepository.save(estudante);
			usuarioRespository.save(usuario);
		} catch(Throwable e) {
			System.out.println(e.getStackTrace());
		}
		

		return "Carga Inicial inserida com sucesso";
			
	}

}
