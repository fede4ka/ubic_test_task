package ubic.service;

import ubic.model.Task;

import java.util.List;

public interface TaskService {
    Task save(Task task);
    List<Task> getall ();
    Long completeTask(Long id);
}
