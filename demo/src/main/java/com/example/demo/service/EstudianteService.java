package com.example.demo.service;

import com.example.demo.model.Estudiante;
import java.util.List;
import java.util.Optional;

public interface EstudianteService {
    List<Estudiante> listarTodos();
    Optional<Estudiante> buscarPorId(Long id);
    Estudiante guardar(Estudiante estudiante);
    Estudiante actualizar(Long id, Estudiante estudiante);
    void eliminar(Long id);
}
