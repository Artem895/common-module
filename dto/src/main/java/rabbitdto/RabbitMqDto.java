package rabbitdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMqDto {
    @JsonProperty("uuid")
    private Long id;

    @JsonProperty("MessageType")
    private MessageType messageType;

    @JsonProperty("Message")
    private String description;

    public Long getId() {
        return id;
    }
}
