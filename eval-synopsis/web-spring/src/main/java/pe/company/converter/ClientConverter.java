package pe.company.converter;

import com.company.webservice.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pe.company.bean.response.ClientResponse;

import java.util.UUID;

@Component
public class ClientConverter implements Converter<Client, ClientResponse> {
    @Override
    public ClientResponse convert(Client source) {
        ClientResponse target = new ClientResponse();
        target.setName(source.getName());
        target.setClientId(source.getClientId());
        target.setLastname(source.getLastname());
        target.setPhone(source.getPhone());
        target.setUuid(UUID.randomUUID().toString());
        return target;
    }
}
