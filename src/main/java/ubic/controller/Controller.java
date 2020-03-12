package ubic.controller;

import org.springframework.web.bind.annotation.*;
import ubic.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import ubic.service.TaskService;

import java.util.List;

@RestController
public class Controller {
        @Autowired
        private TaskService service;
        @PostMapping("/task/save")
        public HttpEntity<Long> save (@RequestBody Task object) {
        Task task = service.save(object);
                return task!= null ? ResponseEntity.ok(task.getId()) : ResponseEntity.badRequest().build();
}
        @GetMapping("/task/getall")
        public List<Task> tasks() { return service.getall(); }

        @PutMapping("/mark/{id}/")
        public String updateTask(@PathVariable Long id) {
               return "Task " +service.completeTask(id) +"completed";
        }
}