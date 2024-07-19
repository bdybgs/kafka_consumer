package cs.vsu.kafka_crypto_weather.service;

import cs.vsu.kafka_crypto_weather.repository.CryptoManualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CryptoManualService {
    private final CryptoManualRepository cryptoManualRepository;


}
