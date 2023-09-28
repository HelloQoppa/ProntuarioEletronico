package com.qoppa.prontuarioEletronico.interfaces;

import java.util.List;

import com.qoppa.prontuarioEletronico.models.Paciente;

public interface IPacienteService<T> {

    public List<T> findAll();

    public T findById(Long id);

    public T save(Paciente paciente);

    public void deleteById(Long id);
}
