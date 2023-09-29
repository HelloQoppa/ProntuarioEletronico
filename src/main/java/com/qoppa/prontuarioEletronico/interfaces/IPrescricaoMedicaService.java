package com.qoppa.prontuarioEletronico.interfaces;

import java.util.List;

import com.qoppa.prontuarioEletronico.models.PrescricaoMedica;

public interface IPrescricaoMedicaService<T> {

    public List<T> findAll();

    public T findById(Long id);

    public T save(PrescricaoMedica prescricaoMedica);

    public void deleteById(Long id);
}
