package ubic.service;

import ubic.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubic.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public Task save(Task task) {
        return repository.save(task);
    }

    @Override
    public List<Task> getall () {
        return (List<Task>) repository.findAll();
    }
    @Override
    public Long completeTask(Long id) {
       Optional<Task> taskOptional = repository.findById((long) id);
       if (taskOptional.isPresent()) {
         Task  task = taskOptional.get();
         task.setCompleted(true);
       repository.save(task);
       return task.getId();}
        else return (long) -1;
    }
}
