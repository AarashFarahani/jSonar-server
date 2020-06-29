package com.jsonar.sample.controllers;

import com.jsonar.sample.models.customer.Customer;
import com.jsonar.sample.repositories.CustomerRepository;
import static org.hamcrest.collection.IsCollectionWithSize.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerRepository customerRepository;

    @WithMockUser(value = "Test1")
    @Test
    public void customers() throws Exception {
        when(this.customerRepository.findAll()).thenReturn(this.customersStub());
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/customers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[*].contactLastName").exists())
                .andExpect(jsonPath("$.[*].contactLastName").isNotEmpty());
    }

    private List<Customer> customersStub() {
        Customer customer1 = new Customer();
        customer1.setCustomerNumber(103);
        customer1.setCustomerName("Atelier graphique");
        customer1.setContactLastName("Schmitt");
        customer1.setContactFirstName("Carine");
        customer1.setPhone("40.32.2555");
        customer1.setAddressLine1("54, rue Royale");
        customer1.setAddressLine2(null);
        customer1.setCity("Nantes");
        customer1.setState(null);
        customer1.setPostalCode("44000");
        customer1.setCountry("France");
        customer1.setCreditLimit(new BigDecimal(21000.00));

        Customer customer2 = new Customer();
        customer2.setCustomerNumber(112);
        customer2.setCustomerName("Signal Gift Stores");
        customer2.setContactLastName("King");
        customer2.setContactFirstName("Jean");
        customer2.setPhone("7025551838");
        customer2.setAddressLine1("8489 Strong St.");
        customer2.setAddressLine2(null);
        customer2.setCity("Las Vegas");
        customer2.setState("NV");
        customer2.setPostalCode("83030");
        customer2.setCountry("USA");
        customer2.setCreditLimit(new BigDecimal(71800.00));

        return Arrays.asList(customer1, customer2);
    }
}
