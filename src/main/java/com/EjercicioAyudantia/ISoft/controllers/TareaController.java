package com.EjercicioAyudantia.ISoft.controllers;
import com.EjercicioAyudantia.ISoft.models.Tarea;
import com.EjercicioAyudantia.ISoft.services.TareaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TareaController {

    private final TareaService tareaService;

    // Inyección de dependencias por constructor
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    // 1. POST /tasks (Rama: feature/post-task)
    @PostMapping
    public ResponseEntity<Tarea> createTask(@RequestBody Tarea tarea) {
        Tarea createdTask = tareaService.createTask(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask); // Retorna 201 Created
    }

    // 2. GET /tasks (Rama: feature/get-tasks-filter)
    @GetMapping
    public ResponseEntity<List<Tarea>> getTasks(
            @RequestParam(required = false) String prioridad,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String fechaLimite) {

        List<Tarea> filteredTasks = tareaService.getTasks(prioridad, titulo, fechaLimite);
        return ResponseEntity.ok(filteredTasks); // Retorna 200 OK con la lista filtrada
    }

    // 3. PATCH /tasks/{id}/complete (Rama: feature/complete-task)
    @PatchMapping("/{id}/complete")
    public ResponseEntity<Tarea> completeTask(@PathVariable Long id) {
        return tareaService.completeTask(id)
                .map(ResponseEntity::ok) // Retorna 200 OK si existe
                .orElse(ResponseEntity.notFound().build()); // Retorna 404 Not Found si no existe
    }
}

