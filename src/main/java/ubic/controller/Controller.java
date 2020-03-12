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
                Long id = service.save(object);
                return id!= null ? ResponseEntity.ok(id) : ResponseEntity.badRequest().build();
}
        @GetMapping("/task/getall")
        public List<Task> tasks() { return service.getall(); }
        @GetMapping("/task/getnotcompletedtasks")
        public List<Task> notCompletedTasts() { return service.getNotCompletedTasks(); }
        @PutMapping("/mark/{id}/")
        public String updateTask(@PathVariable Long id) {
               return "Task " +service.completeTask(id) +"completed";
        }
}