package com.myapp.controller.mapper;

import com.myapp.datatransferobject.VelaDTO;
import com.myapp.domainobject.VelaDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class VelaMapper {

    public static VelaDTO makeVelaDTO(VelaDO velaDO) {

        VelaDTO.VelaDTOBuilder velaDTOBuilder = new VelaDTO.VelaDTOBuilder()
                .setId(velaDO.getId());

        return velaDTOBuilder.build();
    }

    public static VelaDO makeVelaDO(VelaDTO velaDTO) {
        return new VelaDO(velaDTO.getId());
    }

    public static List<VelaDTO> makeVelaDTOList(Collection<VelaDO> velas)
    {
        return velas.stream()
                .map(VelaMapper::makeVelaDTO)
                .collect(Collectors.toList());
    }
}
