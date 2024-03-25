package com.myapp.dataaccessobject;

import com.myapp.domainobject.VelaDO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VelaRepository extends CrudRepository<VelaDO, String> {

    List<VelaDO> getVelas(int qtd);
}
