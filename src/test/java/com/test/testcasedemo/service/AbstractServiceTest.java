package com.test.testcasedemo.service;

import com.test.testcasedemo.TestcasedemoApplication;
import com.test.testcasedemo.exception.ControllerAdvicer;
import com.test.testcasedemo.repository.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@ActiveProfiles(value = "test")
@ExtendWith({SpringExtension.class})
@WebAppConfiguration
@SpringBootTest(classes = TestcasedemoApplication.class)
public class AbstractServiceTest {
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext context;

    @Autowired
    @InjectMocks
    protected ControllerAdvicer controllerAdvicer;

//    @Autowired
//    protected ProductEntityMock productEntityMock;

    @MockBean
    protected ProductRepo productRepo;


    @BeforeEach
    public void data() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

}
