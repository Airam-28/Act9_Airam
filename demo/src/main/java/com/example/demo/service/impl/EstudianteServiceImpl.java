package com.example.demo.service.impl;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }

    @Override
    public Optional<Estudiante> buscarPorId(Long id) {
        return estudianteRepository.findById(id);
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante actualizar(Long id, Estudiante estudianteDetalles) {
        return estudianteRepository.findById(id)
                .map(estudiante -> {
                    estudiante.setNombre(estudianteDetalles.getNombre());
                    estudiante.setEmail(estudianteDetalles.getEmail());
                    estudiante.setEdad(estudianteDetalles.getEdad());
                    return estudianteRepository.save(estudiante);
                }).orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));
    }

    @Override
    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }
}
