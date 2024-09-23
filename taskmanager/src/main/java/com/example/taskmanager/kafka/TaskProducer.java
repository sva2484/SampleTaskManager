import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public TaskProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTaskNotification(String message) {
        kafkaTemplate.send("task-notifications", message);
    }
}
