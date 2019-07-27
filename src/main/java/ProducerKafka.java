
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ProducerKafka {
    private static Properties props(){
        Properties prop = new Properties();
        prop.put("bootstrap.servers", "localhost:9092");
        prop.put("acks", "all");
        // prop.put("delivery.timeout.ms", 30000);
        prop.put("batch.size", 16384);
        //prop.put("linger.ms", 1);
        prop.put("buffer.memory", 33554432);
        prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return prop;
    }

    public static void exec(String data,String topic)  {
        Properties prop = props();
        Producer <String, String> producer = new KafkaProducer<>(prop);
        producer.send(new ProducerRecord<String, String>(topic,data));
        producer.close();
    }
}
