package com.myapp.domainobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.ZonedDateTime;

@AllArgsConstructor
public class VelaDO {

    @Getter
    private Long id;

    @Getter
    private ZonedDateTime created;

    @Getter
    private float crashPoint;

    @Getter
    private String platform;

    public VelaDO(Long id2) {
        //TODO Auto-generated constructor stub
    }

}
