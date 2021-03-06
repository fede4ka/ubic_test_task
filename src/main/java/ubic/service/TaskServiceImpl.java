package ubic.service;

import ubic.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubic.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    //параметр запуска ограничивающий количество незавершенных задач в списке,
    // если достигнут, то задачу поставить нельзя.
    private int count = 2;
    @Autowired
    private TaskRepository repository;
    @Override
    public Long save(Task task) {
        if(isfree())
        {repository.save(task);
        return task.getId();}
        else return (long) -1;
    }
    @Override
    public boolean isfree() { return repository.taskscount()<count; }
    @Override
    public List<Task> getall () { return (List<Task>) repository.findAll(); }
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
    @Override
    public List<Task> getNotCompletedTasks() { return repository.getNotCompletedTasks(); }
}
