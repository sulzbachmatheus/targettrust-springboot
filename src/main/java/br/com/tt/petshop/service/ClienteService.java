package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

//stereotype para conseguir instanciar essa classe na Controller, ou com @Service ou com @Configuration e @Bean
@Service
public class ClienteService {

    public final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public void adicionar(Cliente novoCliente){
        clienteRepository.save(novoCliente);
    }

    public void remover(Long id){
        //TODO alterar no JPA
        Cliente cliente = new Cliente();
        cliente.setId(id);
        clienteRepository.delete(cliente);
    }


}
