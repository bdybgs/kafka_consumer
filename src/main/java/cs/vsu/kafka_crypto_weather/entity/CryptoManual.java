package cs.vsu.kafka_crypto_weather.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "crypto_manual")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CryptoManual {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    private String symbol;
    private Double buyBorder;
    private Double sellBorder;

}
