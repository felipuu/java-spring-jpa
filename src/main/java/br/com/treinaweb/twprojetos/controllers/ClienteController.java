package br.com.treinaweb.twprojetos.controllers;

import br.com.treinaweb.twprojetos.entidades.Cliente;
import br.com.treinaweb.twprojetos.entidades.Uf;
import br.com.treinaweb.twprojetos.repositorios.ClienteRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepositorio clienteRepositorio;

    public ClienteController(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("cliente/home");
        modelAndView.addObject("clientes", clienteRepositorio.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id){
        clienteRepositorio.deleteById(id);
        return "redirect:/clientes";
    }

    @GetMapping("{id}/detalhes")
    public ModelAndView detalhes(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("cliente/detalhes");
        modelAndView.addObject("cliente", clienteRepositorio.getOne(id));
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView modelAndView = new ModelAndView("cliente/formulario");
        modelAndView.addObject("cliente", new Cliente());
        modelAndView.addObject("ufs", Uf.values());
        return modelAndView;
    }

    @GetMapping("{id}/editar")
    public ModelAndView editar(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("cliente/formulario");
        modelAndView.addObject("cliente", clienteRepositorio.getOne(id));
        modelAndView.addObject("ufs", Uf.values());
        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Cliente cliente){
        clienteRepositorio.save(cliente);
        return "redirect:/clientes";
    }

}
