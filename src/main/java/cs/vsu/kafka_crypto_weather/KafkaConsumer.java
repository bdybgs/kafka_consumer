package cs.vsu.kafka_crypto_weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.vsu.kafka_crypto_weather.DTO.WeatherDTO;
import cs.vsu.kafka_crypto_weather.service.CryptoWeatherService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ObjectMapper objectMapper;
    private final CryptoWeatherService cryptoWeatherService;
    @SneakyThrows
    @KafkaListener(topics = "weather", groupId = "weather_group")
    public void listen(ConsumerRecord<String, String> record) throws JsonProcessingException {


        var jsonNode = objectMapper.readTree(record.value());
        var parser = objectMapper.treeAsTokens(jsonNode);
        var weatherDTO = objectMapper.readValue(parser, WeatherDTO.class);

        var cryptoWeatherDataDTOS = cryptoWeatherService.loadCryptoByCity(weatherDTO);

        cryptoWeatherDataDTOS.forEach(x -> log.info(x.toString()));
        //log.info("Received " + value);
    }
}
