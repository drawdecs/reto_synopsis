package pe.company.bean.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClientResponse implements Serializable {

	private static final long serialVersionUID = 3731512622883862058L;
	
	private Long clientId;
    private String name;
    private String lastname;
    private String phone;
    private String uuid;
}
