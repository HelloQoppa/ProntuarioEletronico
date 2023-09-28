package com.qoppa.prontuarioEletronico.interfaces;

import java.util.List;

import com.qoppa.prontuarioEletronico.models.Prontuario;

public interface IProntuarioService<T> {

    public List<T> findAll();

    public T findById(Long id);

    public T save(Prontuario prontuario);

    public void deleteById(Long id);
}
