package pe.company.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import pe.com.synopsis.client.soap.ClientWs;

@Configuration
@AllArgsConstructor
public class WsConfig {

    @Bean
    public ClientWs clientWs(WebServiceTemplate template, @Value("${client.ws.url}") String url) {
        return new ClientWs(template, url, new SoapActionCallback(""));
    }

}
