package pe.company.bean.request;

import lombok.Data;

@Data
public class AddClientRequest {
    private String name;
    private String lastname;
    private String phone;
}
