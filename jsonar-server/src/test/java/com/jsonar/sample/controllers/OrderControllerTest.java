package com.jsonar.sample.controllers;

import com.jsonar.sample.models.Order;
import com.jsonar.sample.models.OrderDetail;
import com.jsonar.sample.models.Product;
import com.jsonar.sample.repositories.CustomerRepository;
import com.jsonar.sample.repositories.OrderDetailRepository;
import com.jsonar.sample.repositories.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrderRepository orderRepository;
    @MockBean
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void customerOrders() throws Exception {
        when(this.orderRepository.findByCustomerNumber(128)).thenReturn(this.ordersStub());

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/customerOrders/128")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$.[*].comments").exists())
                .andExpect(jsonPath("$.[*].comments").value("Check on availability."));
    }

    @Test
    public void orderDetails() throws Exception {
        when(this.orderDetailRepository.findByOrderNumber(10100)).thenReturn(this.orderDetailsStub());

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/orderDetails/10100")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[*].priceEach").exists())
                .andExpect(jsonPath("$.[*].product").isNotEmpty());
    }

    private List<Order> ordersStub() {
        Order order = new Order();
        order.setOrderNumber(10101);
        order.setOrderDate(LocalDate.of(2003, 01, 9));
        order.setRequiredDate(LocalDate.of(2003, 01, 18));
        order.setShippedDate(LocalDate.of(2003, 01, 11));
        order.setStatus("Shipped");
        order.setComments("Check on availability.");

        return Arrays.asList(order);
    }

    private List<OrderDetail> orderDetailsStub() {
        Product product = new Product();
        product.setProductCode("S18_1749");
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setOrderNumber(10100);
        orderDetail1.setQuantityOrdered(30);
        orderDetail1.setPriceEach(new BigDecimal(136.00));
        orderDetail1.setProduct(product);

        product = new Product();
        product.setProductCode("S18_2248");
        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setOrderNumber(10100);
        orderDetail2.setQuantityOrdered(50);
        orderDetail2.setPriceEach(new BigDecimal(55.09));
        orderDetail2.setProduct(product);

        return Arrays.asList(orderDetail1, orderDetail2);
    }
}
