package cs.vsu.kafka_crypto_weather.entity;

public enum CryptoWeatherState {
    BUY("BUY"), CONTINUE_BUYING("CONTINUE_BUYING"), SELL("SELL");

    private final String name;

    CryptoWeatherState(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
