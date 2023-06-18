package br.com.treinaweb.twprojetos.controllers;

import br.com.treinaweb.twprojetos.entidades.Cargo;
import br.com.treinaweb.twprojetos.entidades.Uf;
import br.com.treinaweb.twprojetos.repositorios.CargoRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cargos")
public class CargoController {
    
    private final CargoRepositorio cargoRepositorio;

    public CargoController(CargoRepositorio cargoRepositorio) {
        this.cargoRepositorio = cargoRepositorio;
    }

    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("cargo/home");
        modelAndView.addObject("cargos", cargoRepositorio.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id){
        cargoRepositorio.deleteById(id);
        return "redirect:/cargos";
    }
    
    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView modelAndView = new ModelAndView("cargo/formulario");
        modelAndView.addObject("cargo", new Cargo());
        modelAndView.addObject("ufs", Uf.values());
        return modelAndView;
    }

    @GetMapping("{id}/editar")
    public ModelAndView editar(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("cargo/formulario");
        modelAndView.addObject("cargo", cargoRepositorio.getOne(id));
        modelAndView.addObject("ufs", Uf.values());
        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Cargo cargo){
        cargoRepositorio.save(cargo);
        return "redirect:/cargos";
    }
}
