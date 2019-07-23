package br.com.tt.petshop.controller;

import br.com.tt.petshop.exception.BusinessException;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animais-listar")
    public String listar(Model model, @RequestParam Long clientId){
        //List<Animal> listaAnimais = animalService.listar(clientId);
        model.addAttribute("animais", animalService.listar(clientId));
        return "animais-listar";
    }

    @GetMapping("/animal-adicionar")
    public String animalAdicionar(Model model){
        return "animal-adicionar";
    }

    @PostMapping("/animal-form")
    public String animalForm(Animal novoAnimal, Model model){

        animalService.adicionar(novoAnimal);

        return "animal-adicionar";
    }

}
