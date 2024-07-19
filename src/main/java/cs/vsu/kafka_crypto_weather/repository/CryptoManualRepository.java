package cs.vsu.kafka_crypto_weather.repository;

import cs.vsu.kafka_crypto_weather.entity.CryptoManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CryptoManualRepository extends JpaRepository<CryptoManual, UUID> {
    boolean existsBySymbolIgnoreCase(String symbol);

    CryptoManual findBySymbolIgnoreCase (String symbol);
    void deleteBySymbolIgnoreCase(String symbol);

}
