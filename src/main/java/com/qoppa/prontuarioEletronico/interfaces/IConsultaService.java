package com.qoppa.prontuarioEletronico.interfaces;

import java.util.List;

import com.qoppa.prontuarioEletronico.models.Consulta;

public interface IConsultaService<T> {

    public List<T> findAll();

    public T findById(Long id);

    public T save(Consulta consulta);

    public void deleteById(Long id);
}
