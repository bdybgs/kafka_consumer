package cs.vsu.kafka_crypto_weather.service;

import cs.vsu.kafka_crypto_weather.entity.CryptoManual;
import cs.vsu.kafka_crypto_weather.repository.CryptoManualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CryptoManualService {
    private final CryptoManualRepository cryptoManualRepository;
    public Set<String> findAllCryptoSymbolsByCity(String city) {
        var cryptoManuals = cryptoManualRepository.findAll();
        var symbols = new HashSet<String>();
        for (CryptoManual cryptoManual : cryptoManuals) {
            if (cryptoManual.getCity().equals(city)) {
                symbols.add(cryptoManual.getSymbol());
            }
        }
        return symbols;
    }

    public CryptoManual findBySymbolIgnoreCase(String symbol) {
        return cryptoManualRepository.findBySymbolIgnoreCase(symbol);
    }
}
