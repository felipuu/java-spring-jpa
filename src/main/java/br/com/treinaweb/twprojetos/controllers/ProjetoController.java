package br.com.treinaweb.twprojetos.controllers;

import br.com.treinaweb.twprojetos.entidades.Projeto;
import br.com.treinaweb.twprojetos.repositorios.ClienteRepositorio;
import br.com.treinaweb.twprojetos.repositorios.FuncionarioRepositorio;
import br.com.treinaweb.twprojetos.repositorios.ProjetoRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {
    private final ProjetoRepositorio projetoRepositorio;
    private final FuncionarioRepositorio funcionarioRepositorio;
    private final ClienteRepositorio clienteRepositorio;

    public ProjetoController(ProjetoRepositorio projetoRepositorio,
                             FuncionarioRepositorio funcionarioRepositorio,
                             ClienteRepositorio clienteRepositorio) {
        this.projetoRepositorio = projetoRepositorio;
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.clienteRepositorio = clienteRepositorio;
    }

    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("projeto/home");
        modelAndView.addObject("projetos", projetoRepositorio.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhes(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("projeto/detalhes");
        modelAndView.addObject("projeto", projetoRepositorio.getOne(id));
        return modelAndView;
    }
    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id){
        projetoRepositorio.deleteById(id);
        return "redirect:/projetos";
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView modelAndView = new ModelAndView("projeto/formulario");
        modelAndView.addObject("projeto", new Projeto());
        modelAndView.addObject("clientes", clienteRepositorio.findAll());
        modelAndView.addObject("lideres", funcionarioRepositorio.buscarPorCargo("Gerente"));
        modelAndView.addObject("funcionarios", funcionarioRepositorio.buscarPorCargoExceto("Gerente"));
        return modelAndView;
    }

    @GetMapping("{id}/editar")
    public ModelAndView editar(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("projeto/formulario");
        modelAndView.addObject("projeto",projetoRepositorio.getOne(id));
        modelAndView.addObject("clientes", clienteRepositorio.findAll());
        modelAndView.addObject("lideres", funcionarioRepositorio.buscarPorCargo("Gerente"));
        modelAndView.addObject("funcionarios", funcionarioRepositorio.buscarPorCargoExceto("Gerente"));
        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Projeto projeto){
        projetoRepositorio.save(projeto);
        return "redirect:/projetos";
    }
}
