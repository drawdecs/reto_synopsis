package pe.company.service;

import com.company.webservice.Client;
import com.company.webservice.ClientsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.synopsis.client.soap.ClientWs;
import pe.company.bean.request.AddClientRequest;
import pe.company.bean.request.DeleteClientRequest;
import pe.company.bean.request.EditClientRequest;
import pe.company.bean.response.ClientResponse;
import pe.company.converter.ClientConverter;
import pe.company.exception.ClientException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl {
    private final ClientConverter converter;
    private final ClientWs clientWs;

    public List<ClientResponse> list() {

        ClientsResponse respWs = clientWs.list();
        List<ClientResponse> clients = respWs.getClients().stream().map((client) -> converter.convert(client)).collect(Collectors.toList());

        return clients;

    }

    public void add(AddClientRequest request){

        com.company.webservice.AddClientRequest wsBean = new com.company.webservice.AddClientRequest();
        
        wsBean.setName(request.getName());
        wsBean.setLastname(request.getLastname());
        wsBean.setPhone(request.getPhone());
        
        com.company.webservice.EditClientRequest requestWs = new com.company.webservice.EditClientRequest();

        this.clientWs.add(wsBean);

    }

    public void edit(EditClientRequest request){

        Client wsBean = new Client();
        
        wsBean.setClientId(request.getId());
        wsBean.setName(request.getName());
        wsBean.setLastname(request.getLastname());
        wsBean.setPhone(request.getPhone());

        com.company.webservice.EditClientRequest requestWs = new com.company.webservice.EditClientRequest();
        requestWs.setClient(wsBean);

        this.clientWs.edit(requestWs);

    }

    public void delete(DeleteClientRequest request) {

        com.company.webservice.DeleteClientRequest requestWs = new com.company.webservice.DeleteClientRequest();
        requestWs.setClientId(request.getClientId());
        this.clientWs.delete(requestWs);

    }

}
