package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

//stereotype para conseguir instanciar essa classe na Controller, ou com @Service ou com @Configuration e @Bean
@Service
public class ClienteService {

    public ClienteService(){
        System.out.println("ClienteService: fui inicializado!");
    }

    public List<Cliente> listar(){
        List<Cliente> listaClientes = Arrays.asList(
                new Cliente("Matheus", "86283855091"),
                new Cliente("Luan", "86283855091"),
                new Cliente("Everton", "86283855091")
        );
        return listaClientes;
    }
}
