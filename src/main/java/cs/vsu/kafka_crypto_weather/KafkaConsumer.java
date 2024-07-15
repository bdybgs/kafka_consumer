package cs.vsu.kafka_crypto_weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.vsu.kafka_crypto_weather.DTO.WeatherDataDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ObjectMapper objectMapper;
    private  final ModelMapper modelMapper;
    @SneakyThrows
    @KafkaListener(topics = "weather", groupId = "weather_group")
    public void listen(ConsumerRecord<String, String> record) throws JsonProcessingException {

        var jsonNode = objectMapper.readTree(record.value());
        var parser = objectMapper.treeAsTokens(jsonNode);
        var value = objectMapper.readValue(parser, WeatherDataDTO.class);

        String city = value.getCity();
        if ("Dubai".equals(city)) {
            log.info(city);
        }

//        modelMapper.map(record, WeatherData.class);

        log.info("Received " + value);
    }
}