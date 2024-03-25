package com.myapp.controller;

import com.google.common.collect.Lists;
import com.myapp.controller.mapper.VelaMapper;
import com.myapp.datatransferobject.VelaDTO;
import com.myapp.domainobject.CarDO;
import com.myapp.domainobject.VelaDO;
import com.myapp.exception.ConstraintsViolationException;
import com.myapp.exception.EntityNotFoundException;
import com.myapp.service.vela.VelaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/velas")
public class VelaController {

    private final VelaService velaService;

    @Autowired
    public VelaController(final VelaService velaService) {
        this.velaService = velaService;
    }

    @GetMapping
    public VelaDTO getVela() {
        int qtd = 0;
        Iterable<VelaDO> result = velaService.findAll(qtd); 
        return VelaMapper.makeVelaDTO(null);
    }
}