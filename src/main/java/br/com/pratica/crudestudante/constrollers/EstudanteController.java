package br.com.pratica.crudestudante.constrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pratica.crudestudante.models.Estudante;
import br.com.pratica.crudestudante.repositorys.EstudanteRepository;

@RestController
public class EstudanteController {

	@Autowired
	private EstudanteRepository estudanteRepository;


	@GetMapping("/estudantes")
	public List<Estudante> buscarEstudantes() {
		return estudanteRepository.findAll();
	}
	
	@GetMapping("/estudantes/{id}")
	public Estudante buscarEstudante(@PathVariable long id) throws Exception {
		Optional<Estudante> estudante = estudanteRepository.findById(id);
		if (!estudante.isPresent())
			throw new Exception("id-" + id);

		
		return estudante.get();
	}
	
	@DeleteMapping("/estudantes/{id}")
	public void deletarEstudante(@PathVariable long id) {
		estudanteRepository.deleteById(id);
		System.out.println("Estudante excluido");
		
	}
	
	@PostMapping("/estudantes")
	public Estudante gravarEstudante(@RequestBody Estudante estudante){
		
		return estudanteRepository.save(estudante);
	}
	
	@PutMapping("/estudantes/{id}")
	public Estudante alterarEstudante(@RequestBody Estudante estudante, @PathVariable long id) throws Exception {
		Optional<Estudante> estudanteOptional = estudanteRepository.findById(id);

		if (!estudanteOptional.isPresent())
			throw new Exception("id-" + id);
		
		estudante.setId(id);
		
		estudanteRepository.save(estudante);
		
		return estudante;
	}
	
}
