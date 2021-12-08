package mx.com.example.commons.stream;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class KafkaTopicConfig {

    @Value(value = "${KAFKA_BOOSTRAPADDRESS}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic("order_events", 2, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic("ticket_events", 2, (short) 1);
    }

    @Bean
    public NewTopic topic3() {
        return new NewTopic("payment_events", 2, (short) 1);
    }
}
