package com.EjercicioAyudantia.ISoft;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;

@Component
public class TaskStore {

    private final Map<Long, Tarea> tasks = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public Map<Long, Tarea> getTasks() {
        return tasks;
    }

    public long nextId() {
        return sequence.incrementAndGet();
    }
}