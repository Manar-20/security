package com.exampleMidPoject.FarasanTrip.Controllar;

import com.exampleMidPoject.FarasanTrip.Entity.Admin;
import com.exampleMidPoject.FarasanTrip.Entity.Booking;
import com.exampleMidPoject.FarasanTrip.Entity.Customer;
import com.exampleMidPoject.FarasanTrip.Entity.FarasanTrip;
import com.exampleMidPoject.FarasanTrip.Repository.AdminRepository;
import com.exampleMidPoject.FarasanTrip.Repository.BookingRepository;
import com.exampleMidPoject.FarasanTrip.Repository.CustomerRepository;
import com.exampleMidPoject.FarasanTrip.Repository.FarasanTripRepository;
import com.exampleMidPoject.FarasanTrip.Service.Implementation.AdminImplementation;
import com.exampleMidPoject.FarasanTrip.Service.Implementation.BookingImplementation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
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

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookingControllarTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired

    private CustomerRepository customerRepository;
    @Autowired

    private AdminRepository adminRepository;
    @Autowired

    private FarasanTripRepository farasanTripRepository;
    @Mock
    private BookingImplementation bookingImplementation ;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

  /*  @Test
    public void testCreateNewBooking_Success() throws Exception {
        Customer customer = new Customer(1107L,"Maram","maram@example.com","Customer");
        customerRepository.save(customer);
        Admin admin = new Admin(12L,"Jood","jood12@example.com","Admin");
        adminRepository.save(admin);
        FarasanTrip newTrip = new FarasanTrip("F103", 4, 99.99, admin);
         farasanTripRepository.save(newTrip);
        Booking newBooking = new Booking(1L,customer, newTrip, "2023-10-25");

        // Mock the behavior of the bookingImpl service
        when(bookingImplementation.createNewBooking(any(Booking.class)));

        // Convert the Booking object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(newBooking);

        mockMvc.perform(post("/Add-new-booking")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("Booking Added Successful"));
    }*/
    @Test
    public void testGetAllBookings() throws Exception {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/All-Booking"))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                    .andReturn();
            assertTrue(mvcResult.getResponse().getContentAsString().contains("Customer"));

    }
    @Test
    public void testDeleteBooking() throws Exception {
        Long bookingId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/delete-Booking/{bookingId}", bookingId))
                .andExpect(status().isOk())
                .andExpect(content().string("Booking Deleted Successful"));
    }

}