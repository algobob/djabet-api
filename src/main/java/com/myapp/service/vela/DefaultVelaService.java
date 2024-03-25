package com.myapp.service.vela;

import com.myapp.dataaccessobject.CarRepository;
import com.myapp.dataaccessobject.VelaRepository;
import com.myapp.domainobject.CarDO;
import com.myapp.domainobject.DriverDO;
import com.myapp.exception.CarAlreadyInUseException;
import com.myapp.exception.ConstraintsViolationException;
import com.myapp.exception.EntityNotFoundException;
import com.myapp.service.driver.DriverService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.myapp.domainvalue.OnlineStatus.ONLINE;

@Service
public class DefaultVelaService implements VelaService {

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(VelaService.class);

    private final VelaRepository velaRepository;

    public DefaultVelaService(final VelaRepository velaRepository) {
        this.velaRepository = velaRepository;
    }   

    @Override
    public Iterable<CarDO> get(int qtd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
}
