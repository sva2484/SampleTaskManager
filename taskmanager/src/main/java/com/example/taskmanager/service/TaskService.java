import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskProducer taskProducer;

    public TaskService(TaskRepository taskRepository, TaskProducer taskProducer) {
        this.taskRepository = taskRepository;
        this.taskProducer = taskProducer;
    }

    public Task createTask(String description, String userId) {
        Task task = new Task(description, userId);
        taskProducer.sendTaskNotification("Task created: " + task.getDescription());
        return taskRepository.save(task);
    }

    public List<Task> getUserTasks(String userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task updateTask(String id, Task updatedTask) {
        updatedTask.setId(id);
        taskProducer.sendTaskNotification("Task updated: " + updatedTask.getDescription());
        return taskRepository.save(updatedTask);
    }

    public void deleteTask(String id) {
        taskProducer.sendTaskNotification("Task deleted: " + id);
        taskRepository.deleteById(id);
    }
}
