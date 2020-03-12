package ubic.service;

import ubic.model.Task;

import java.util.List;

public interface TaskService {
    Long save(Task task);
    List<Task> getall ();
    Long completeTask(Long id);
    boolean isfree();
    List<Task> getNotCompletedTasks();
}
