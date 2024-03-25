package com.myapp.service.vela;

import com.myapp.domainobject.CarDO;
import com.myapp.domainobject.VelaDO;
import com.myapp.exception.CarAlreadyInUseException;
import com.myapp.exception.ConstraintsViolationException;
import com.myapp.exception.EntityNotFoundException;

public interface VelaService {

    CarDO find(String licensePlate) throws EntityNotFoundException;

    CarDO create(CarDO carDO) throws ConstraintsViolationException;

    void delete(String licensePlate) throws EntityNotFoundException, ConstraintsViolationException;

    void addDriver(Long driverId, String licensePlate) throws ConstraintsViolationException, EntityNotFoundException, CarAlreadyInUseException;

    void deleteDriver(Long driverId, String licensePlate) throws ConstraintsViolationException, EntityNotFoundException, CarAlreadyInUseException;

    Iterable<VelaDO> findAll(int qtd);

    Iterable<CarDO> get(int qtd);
}
