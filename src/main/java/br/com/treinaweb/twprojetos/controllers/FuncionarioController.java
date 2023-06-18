package br.com.treinaweb.twprojetos.controllers;

import br.com.treinaweb.twprojetos.entidades.Funcionario;
import br.com.treinaweb.twprojetos.entidades.Uf;
import br.com.treinaweb.twprojetos.repositorios.CargoRepositorio;
import br.com.treinaweb.twprojetos.repositorios.FuncionarioRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioRepositorio funcionarioRepositorio;
    private final CargoRepositorio cargoRepositorio;

    public FuncionarioController(FuncionarioRepositorio funcionarioRepositorio,
                                 CargoRepositorio cargoRepositorio) {
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.cargoRepositorio = cargoRepositorio;
    }

    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("funcionario/home");
        modelAndView.addObject("funcionarios", funcionarioRepositorio.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id){
        funcionarioRepositorio.deleteById(id);
        return "redirect:/funcionarios";
    }

    @GetMapping("{id}/detalhes")
    public ModelAndView detalhes(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("funcionario/detalhes");
        modelAndView.addObject("funcionario", funcionarioRepositorio.getOne(id));
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView modelAndView = new ModelAndView("funcionario/formulario");
        modelAndView.addObject("funcionario", new Funcionario());
        modelAndView.addObject("ufs", Uf.values());
        modelAndView.addObject("cargos", cargoRepositorio.findAll());
        return modelAndView;
    }

    @GetMapping("{id}/editar")
    public ModelAndView editar(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("funcionario/formulario");
        modelAndView.addObject("funcionario", funcionarioRepositorio.getOne(id));
        modelAndView.addObject("cargos", cargoRepositorio.findAll());
        modelAndView.addObject("ufs", Uf.values());

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Funcionario funcionario){
        funcionarioRepositorio.save(funcionario);
        return "redirect:/funcionarios";
    }
}
