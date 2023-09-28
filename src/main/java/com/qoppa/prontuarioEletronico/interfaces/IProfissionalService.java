package com.qoppa.prontuarioEletronico.interfaces;

import java.util.List;

import com.qoppa.prontuarioEletronico.models.Profissional;

public interface IProfissionalService<T> {

    public List<T> findAll();

    public T findById(Long id);

    public T save(Profissional profissional);

    public void deleteById(Long id);
}
