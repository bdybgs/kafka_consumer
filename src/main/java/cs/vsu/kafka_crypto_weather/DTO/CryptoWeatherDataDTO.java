package cs.vsu.kafka_crypto_weather.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CryptoWeatherDataDTO {
    private String symbol;
    private String city;
    private Double temp;
    private Date time;
    private String cryptoWeatherState;
}
