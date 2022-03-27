package com.company.webservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.company.webservice.wsdl.*;
import org.springframework.stereotype.Service;

import com.company.webservice.model.Client;
import com.company.webservice.repository.ClientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl {

    private ClientRepository repository;

    public ClientsResponse findClients() {
        ClientsResponse response = new ClientsResponse();
        response.getClients().addAll(
                ((List<Client>) repository.findAll()).stream().map(
                    (client) -> {
                        com.company.webservice.wsdl.Client clientWs = new com.company.webservice.wsdl.Client();
                        clientWs.setClientId(client.getClientId());
                        clientWs.setName(client.getName());
                        clientWs.setPhone(client.getPhone());
                        clientWs.setLastname(client.getLastName());
                        return clientWs;
                    }
                ).collect(Collectors.toList())
        );

        return response;
    }

    public void addClient(AddClientRequest request) {
        repository.save(
            Client.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .lastName(request.getLastname())
            .build()
        );
    }

    public void editClient(EditClientRequest request) {
        com.company.webservice.wsdl.Client clientWs = request.getClient();
        Optional<Client> optional = repository.findById(clientWs.getClientId());
        if(optional.isPresent()) {
            Client client = optional.get();
            client.setLastName(clientWs.getLastname());
            client.setName(clientWs.getName());
            client.setPhone(clientWs.getPhone());
            repository.save(client);
        }
    }

    public void deleteClient(DeleteClientRequest request) {
        repository.deleteById(request.getClientId());
    }

}
