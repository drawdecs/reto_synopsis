
package pe.com.synopsis.client.soap;

import com.company.webservice.*;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.io.Serializable;

public class ClientWs implements Serializable
{

    private static final long serialVersionUID = -4184457396269278149L;

    private final WebServiceMessageCallback callback;
    private final transient WebServiceTemplate template;
    private final String uri;
    private final ObjectFactory factory;

    public ClientWs(WebServiceTemplate template, String uri, WebServiceMessageCallback callback)
    {
        this.template = template;
        this.callback = callback;
        this.uri = uri;
        factory = new ObjectFactory();
    }

    public ClientsResponse list()
    {
        ListClientRequest request = factory.createListClientRequest();
        return ((ClientsResponse) template.marshalSendAndReceive(uri, request, callback));
    }

    public StatusResponse add(AddClientRequest request)
    {
        return ((StatusResponse) template.marshalSendAndReceive(uri, request, callback));
    }

    public StatusResponse edit(EditClientRequest request)
    {
        return ((StatusResponse) template.marshalSendAndReceive(uri, request, callback));
    }

    public StatusResponse delete(DeleteClientRequest request)
    {
        return ((StatusResponse) template.marshalSendAndReceive(uri, request, callback));
    }

}
