package br.com.tt.petshop.service;

import br.com.tt.petshop.exception.BusinessException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

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

    public void adicionar(Cliente novoCliente) throws BusinessException {
        validaNome(novoCliente);
        validaCpf(novoCliente);
        clienteRepository.save(novoCliente);
    }

    public void remover(Long id){
        //FIXME <---
        //TODO alterar no JPA
        Cliente cliente = new Cliente();
        cliente.setId(id);
        clienteRepository.delete(cliente);
    }

    private void validaNome (Cliente novoCliente) throws BusinessException {
        if(Objects.isNull(novoCliente) || Objects.isNull(novoCliente.getNome())){
            throw new BusinessException("O nome deve ser informado!");
        }
        String[] partes = novoCliente.getNome().split(" ");
        if(partes.length < 2){
            throw new BusinessException("Informe seu nome completo!");
        }
        for (String parte : partes){
            if (parte.length() < 2) {
                throw new BusinessException("Informe seu nome sem abreviações!");
            }
        }
    }

    private void validaCpf(Cliente novoCliente) throws BusinessException {
        if(Objects.isNull(novoCliente) || Objects.isNull(novoCliente.getCpf())){
            throw new BusinessException("O cpf deve ser informado!");
        }
        String cpf = novoCliente.getCpf().replaceAll("\\D", "");
        if(cpf.length() != 11){
            throw new BusinessException("O CPF deve ter 11 caracteres!");
        }else{
            novoCliente.setCpf(cpf);
        }
    }


}
