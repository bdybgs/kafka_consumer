package cs.vsu.kafka_crypto_weather.service;

import cs.vsu.kafka_crypto_weather.repository.CryptoManualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CryptoManualService {
    private final CryptoManualRepository cryptoManualRepository;
    public Set<String> findAllCryptosByCity(String city) {
        cryptoManualRepository.findAll();



        return
    }
}
