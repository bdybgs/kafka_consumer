package cs.vsu.kafka_crypto_weather.DTO;

import lombok.*;

import java.util.Date;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter
@Builder
@ToString
public class WeatherDTO {
    private String id;

    private String city;

    private Double temp;

    private Date time;



}
