package com.exampleMidPoject.FarasanTrip.Controllar;

import com.exampleMidPoject.FarasanTrip.Entity.Admin;
import com.exampleMidPoject.FarasanTrip.Entity.FarasanTrip;
import com.exampleMidPoject.FarasanTrip.Repository.AdminRepository;
import com.exampleMidPoject.FarasanTrip.Repository.CustomerRepository;
import com.exampleMidPoject.FarasanTrip.Repository.FarasanTripRepository;
import com.exampleMidPoject.FarasanTrip.Service.Implementation.CustmoerImplementation;
import com.exampleMidPoject.FarasanTrip.Service.Implementation.FarasanTripImplementation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FarasanTripControllarTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private FarasanTripRepository farasanTripRepository;
@Autowired
private AdminRepository adminRepository;
    @Mock
    private FarasanTripImplementation farasanTripImplementation;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    /*@Test
    public void testAddNewTrip() throws Exception {
        // Create a sample FarasanTrip object for the reques
        Admin admin = new Admin(12L,"Jood","jood12@example.com","Admin");
        adminRepository.save(admin);
        FarasanTrip newTrip = new FarasanTrip("F103", 4, 99.99, admin);

        // Mock the behavior of the farasanTripImpl service
        when(farasanTripImplementation.addNewTrip(any(FarasanTrip.class)));

        // Convert the FarasanTrip object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(newTrip);

        mockMvc.perform(post("/add-new-Trip")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("Trip created Successful"));
    }*/
    /*@Test
    public void testUpdateTrip() throws Exception {
        String farryName = "F102";
        Admin admin = new Admin(11L,"Hamad","hamad@example.com","Admin");
        adminRepository.save(admin);
        FarasanTrip updatedTrip = new FarasanTrip("F102", 4, 99.99, admin);
        farasanTripRepository.save(updatedTrip);
        // Mock the behavior of the farasanTripImpl service to throw an exception
        when(farasanTripImplementation.updateTripById(farryName, updatedTrip)).thenThrow(new RuntimeException("Error message"));

        // Perform a PUT request to the /Update-Trip_Info endpoint
        mockMvc.perform(put("/Update-Trip_Info/{farryName}", farryName)
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(updatedTrip)))
                .andExpect(status().isOk())
                .andExpect(content().string("Trip Information is Updated"));
    }*/
    @Test
    public void testGetAllTrips() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/trips"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("F115"));
    }
}