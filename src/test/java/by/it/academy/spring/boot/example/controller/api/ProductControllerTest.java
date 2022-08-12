package by.it.academy.spring.boot.example.controller.api;

import by.it.academy.spring.boot.example.model.Manufacturer;
import by.it.academy.spring.boot.example.model.Product;
import by.it.academy.spring.boot.example.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProductControllerTest {

    public static final Integer ID = 1;
    public static final String MANUFACTURER = "BMW";
    public static final String MODEL = "X5";
    public static final double PRICE = 500.99;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        Product product = Product.builder()
                .id(ID.longValue())
                .manufacturer(Manufacturer.builder().id(1L).build())
                .model(MODEL)
                .price(PRICE).build();
        when(productRepository.findById(ID.longValue())).thenReturn(Optional.of(product));
    }

    @Test
    @WithMockUser("USER")
    public void getProductById() throws Exception {
        mockMvc.perform(get("/api/products/" + ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(ID)))
                .andExpect(jsonPath("$.manufacturer", is(MANUFACTURER)))
                .andExpect(jsonPath("$.model", is(MODEL)))
                .andExpect(jsonPath("$.price", is(PRICE)));
    }

    @Test
    public void find_no_login_401() throws Exception {
        mockMvc.perform(get("/api/products/" + ID))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }


}
