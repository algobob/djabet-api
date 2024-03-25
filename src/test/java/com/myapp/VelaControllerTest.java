package com.myapp;

import com.jayway.jsonpath.JsonPath;
import com.myapp.controller.VelaController;
import com.myapp.datatransferobject.VelaDTO;
import com.myapp.domainobject.CarDO;
import com.myapp.domainobject.VelaDO;
import com.myapp.domainvalue.EngineType;
import com.myapp.service.car.CarService;
import com.myapp.service.vela.VelaService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = VelaController.class, secure = false)
public class VelaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @MockBean
    private VelaService velaService;

    private static final String LICENSE_PLATE = "546PW";

    private CarDO carDOResult = new CarDO(LICENSE_PLATE, 4, false, 10, EngineType.GAS, "MERCEDES");

    @Test
    public void getVelas() throws Exception {
        VelaDO vela1 = new VelaDO(1L);
        VelaDO vela2 = new VelaDO(2L);

        Mockito.when(velaService.findAll(Mockito.anyInt())).thenReturn(List.of(vela1, vela2));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/velas?qtd=200")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String velas = JsonPath.parse(result.getResponse().getContentAsString()).toString();

        JSONAssert.assertEquals("[{id:1},{id:2}]", velas, false);

    }

    @Test
    public void createCar() throws Exception {

        Mockito.when(carService.create(Mockito.any(CarDO.class))).thenReturn(carDOResult);

        String exampleCar = "{\"licensePlate\":\"546PW\",\"seatCount\":\"4\",\"convertible\":\"false\",\"rating\":\"10\",\"engineType\":\"GAS\",\"manufacturer\":\"MERCEDES\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/v1/cars")
                .accept(MediaType.APPLICATION_JSON).content(exampleCar)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    public void getCar() throws Exception {

        Mockito.when(carService.find(LICENSE_PLATE)).thenReturn(carDOResult);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/v1/cars/" + LICENSE_PLATE).accept(
                        MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{\"licensePlate\":\"546PW\",\"seatCount\":4,\"convertible\":false,\"rating\":10,\"engineType\":\"GAS\",\"manufacturer\":\"MERCEDES\"}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

}
