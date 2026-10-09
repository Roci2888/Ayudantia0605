package com.EjercicioAyudantia.ISoft.services;
import com.EjercicioAyudantia.ISoft.models.Tarea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class TareaService {

        // Lista en memoria compartida
        private final List<Tarea> tasks = new ArrayList<>();
        // Generador autoincremental para el ID
        private final AtomicLong idCounter = new AtomicLong(1);

        // POST /tasks
        public Tarea createTask( Tarea task) {
            task.setId(idCounter.getAndIncrement()); // Asigna ID autoincremental
            tasks.add(task);
            return task;
        }

        // GET /tasks con filtros acumulables
        public List<Tarea> getTasks(String prioridad, String titulo, String fechaLimite) {
            return tasks.stream()
                    .filter(t -> prioridad == null || t.getPrioridad().equalsIgnoreCase(prioridad))
                    .filter(t -> titulo == null || t.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                    .filter(t -> fechaLimite == null || (t.getFechaLimite() != null && t.getFechaLimite().equals(fechaLimite)))
                    .collect(Collectors.toList());
        }

        // PATCH /tasks/{id}/complete
        public Optional<Tarea> completeTask(Long id) {
            for (Tarea t : tasks) {
                if (t.getId().equals(id)) {
                    t.setCompletada(true);
                    return Optional.of(t);
                }
            }
            return Optional.empty();
        }
    }

