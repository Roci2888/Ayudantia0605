package com.EjercicioAyudantia.ISoft;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskGetController {

    private final TaskStore store;

    public TaskGetController(TaskStore store) {
        this.store = store;
    }

    @GetMapping
    public List<Tarea> listar(
            @RequestParam(name = "prioridad", required = false)
            String prioridad) {

        return store.getTasks().values().stream()
                .filter(tarea -> prioridad == null
                        || prioridad.equals(tarea.getPrioridad()))
                .collect(Collectors.toList());
    }
}