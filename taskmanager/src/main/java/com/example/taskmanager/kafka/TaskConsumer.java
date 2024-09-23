import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TaskConsumer {
    @KafkaListener(topics = "task-notifications", groupId = "task-manager-group")
    public void listen(String message) {
        System.out.println("Received notification: " + message);
    }
}
