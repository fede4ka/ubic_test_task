package ubic.repository;

import org.springframework.data.jpa.repository.Query;
import ubic.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Query(value = "SELECT count (*) FROM TASKS WHERE completed = false", nativeQuery = true)
    int taskscount();

    @Query(value = "SELECT * FROM TASKS WHERE completed = false", nativeQuery = true)
    List<Task> getNotCompletedTasks();

}
