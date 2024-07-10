package cs.vsu.kafka_crypto_weather;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "weather", groupId = "weather_group")
    public void listen(String record) {
        System.out.println("Received " + record);
    }
}
