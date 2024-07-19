package cs.vsu.kafka_crypto_weather.repository;

import cs.vsu.kafka_crypto_weather.entity.CryptoManual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CryptoManualRepository extends JpaRepository<CryptoManual, UUID> {

}
