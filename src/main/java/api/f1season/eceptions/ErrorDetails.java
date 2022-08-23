package api.f1season.eceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {

    private Date createAt;
    
    private String message;
    
    private String endpoint;
}
