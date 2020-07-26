package atividadent.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ativaden.model.Pessoa;

@Repository
@Transactional
public interface PessoaRepository extends CrudRepository<Pessoa, Long>  {
	@Query(value = "select id from pessoa where DATA = ?1 and HORA = ?2 and MIN=?3", nativeQuery = true)
	List<Pessoa> findPessoaByDataHora(Date data, int hora, int min);
	
	
}
