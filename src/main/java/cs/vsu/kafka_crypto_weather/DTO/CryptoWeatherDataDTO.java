package cs.vsu.kafka_crypto_weather.DTO;

import cs.vsu.kafka_crypto_weather.entity.CryptoWeatherState;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CryptoWeatherDataDTO {
    private Date time;
    private String symbol;
    private CryptoWeatherState cryptoWeatherState;

}
