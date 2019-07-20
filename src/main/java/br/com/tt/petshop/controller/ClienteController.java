package br.com.tt.petshop.controller;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ClienteController {
    //clienteService está sendo instanciado por baixo dos panos
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("Sistema", "PetShop");
        List<Cliente> listaClientes = clienteService.listar();
        model.addAttribute("clientes", listaClientes);
        return "index";
    }

    @GetMapping("/cliente-adicionar")
    public String paginaAdicionar(Model model){
        return "cliente-adicionar";
    }

    @PostMapping("/cliente-form")
    public RedirectView clienteForm(Cliente novoCliente){
        clienteService.adicionar(novoCliente);
        return new RedirectView("/");
    }

    @GetMapping("/cliente-excluir")
    public RedirectView clienteExcluir(@RequestParam Long id){
        clienteService.remover(id);
        return new RedirectView("/");
    }
}
