package com.atividadent.atividadent;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import ativaden.model.Pessoa;
import atividadent.repository.PessoaRepository;

@Controller
public class IndexController {//É o que faz a ligação do que vem do banco de dados(modelo) e manda para view.
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@RequestMapping(method = RequestMethod.GET, value="/")
	public String index() {
		return "index.html";
	}
	
	
	@RequestMapping("/Agendar") //Aqui criamos o metodo agendar e vereficamos antes se existe a pessoa no banco.
	public ModelAndView agendar(Pessoa pessoa, Date data, int hora, int min) {
				
		ModelAndView modelAndView = new ModelAndView("cadastropessoa.html"); 
		//modelAndView.addObject("pessoas", pessoaRepository.findPessoaByDataHora(data, hora, min));
		List<Pessoa> md = pessoaRepository.findPessoaByDataHora(data, hora, min);
		if(md == null || md.size() == 0){
			pessoaRepository.save(pessoa);
			Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
			modelAndView.addObject("pessoas", pessoasIt);
			return modelAndView;
		}
		
		ModelAndView mv = new ModelAndView("msgerro.html");
		String mensagem = "Já existe um agendamento para a data "+ data + " no horário:" + hora + ":" + min;
		mv.addObject("mensagem", mensagem);
		return mv;
			
	}

	
	@RequestMapping(method= RequestMethod.GET, value="/listapessoas")
	public ModelAndView	pessoas() {
		ModelAndView andView = new ModelAndView("cadastropessoa.html");
		Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
		andView.addObject("pessoas", pessoasIt);
		return andView;
	}
	
	
	
	@RequestMapping("/chamarcadastro")
	public String chamarcadastro() {
		return "cadastropessoa.html";
	}
	
	
	
}




