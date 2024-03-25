package com.myapp.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class VelaDTO {

    @JsonIgnore
    private Long id;

    private VelaDTO() {
    }

    private VelaDTO(Long id) {
        this.id = id;
    }

    public static class VelaDTOBuilder {
        private Long id;

        public VelaDTO build() {
            return new VelaDTO(id);
        }

        public VelaDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }
    }
}
