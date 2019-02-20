package br.com.pratica.crudestudante.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pratica.crudestudante.models.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
