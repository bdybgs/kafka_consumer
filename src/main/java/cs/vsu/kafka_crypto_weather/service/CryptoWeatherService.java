package cs.vsu.kafka_crypto_weather.service;

import cs.vsu.kafka_crypto_weather.DTO.CryptoWeatherDataDTO;
import cs.vsu.kafka_crypto_weather.DTO.WeatherDTO;
import cs.vsu.kafka_crypto_weather.entity.CryptoManual;
import cs.vsu.kafka_crypto_weather.entity.CryptoWeatherState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CryptoWeatherService {

    private final CryptoManualService cryptoManualService;

    public List<CryptoWeatherDataDTO> loadCryptoForCity(WeatherDTO weatherDTO) {
        Set<String> cryptoSymbols = cryptoManualService.findAllCryptoSymbolsByCity(weatherDTO.getCity());
        var res = new LinkedList<CryptoWeatherDataDTO>();
        for (String symbol: cryptoSymbols) {
            CryptoManual cryptoManual = cryptoManualService.findBySymbolIgnoreCase(symbol);
            var cryptoWeatherState = getCurrentCryptoWeatherStateByTemp(
                    weatherDTO.getTemp(), cryptoManual.getBuyBorder(), cryptoManual.getSellBorder()
            );
            var cryptoWeatherDataDTO = CryptoWeatherDataDTO.builder()
                    .time(weatherDTO.getTime())
                    .symbol(symbol)
                    .cryptoWeatherState(cryptoWeatherState)
                    .build();
            res.add(cryptoWeatherDataDTO);
        }
        return res;
    }

    private CryptoWeatherState getCurrentCryptoWeatherStateByTemp(Double temp, Double buyBorder, Double sellBorder) {
        if (temp < buyBorder) {
            return CryptoWeatherState.CONTINUE_BUYING;
        } else if (temp > sellBorder) {
            return CryptoWeatherState.SELL;
        } else {
            return CryptoWeatherState.BUY;
        }
    }
}
