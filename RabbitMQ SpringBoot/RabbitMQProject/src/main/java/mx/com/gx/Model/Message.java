package mx.com.gx.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {
    private String mensaje;
    private String en;
    private String timestamp;
}
