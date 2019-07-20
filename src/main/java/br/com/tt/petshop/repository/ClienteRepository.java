package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.stereotype.Repository;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//esta anotação faz com que seja um singleton
@Repository
public class ClienteRepository {

    List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente((long) 1, "Matheus", "86283855091"),
            new Cliente((long) 2, "Luan", "86283855091"),
            new Cliente((long) 3, "Everton", "86283855091")
    ));

    public void save(Cliente cliente){
        try {
            cliente.setId(SecureRandom.getInstanceStrong().nextLong());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        clientes.add(cliente);
    }

    public List<Cliente> findAll(){
        return clientes;
    }

    public void delete(Cliente cliente){
        clientes.remove(cliente);
    }
}
