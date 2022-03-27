package pe.company.bean.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ErrorResponse implements Serializable {
    private String code;
    private String message;
}
