package com.jsonar.sample.controllers;

import com.jsonar.sample.models.User;
import com.jsonar.sample.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    public void login() throws Exception {
        User user = new User("Test1", "");
        user.setToken("knjiyu");

        when(this.userService
                .findAuthorizedUser("Test1", "test1@mytest.com"))
                .thenReturn(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"username\": \"Test1\",\n" +
                        "    \"password\": \"test1@mytest.com\"\n" +
                        "}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists())
                .andExpect(jsonPath("$.token").value("knjiyu"));
    }
}
