package com.beta.wheelsup.controller;

/**
 * Created by mburns on 1/19/16.
 */


import com.beta.wheelsup.config.TestConfig;
import com.beta.wheelsup.config.WebAppConfig;
import com.beta.wheelsup.service.SalesPersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class, WebAppConfig.class})
@WebAppConfiguration
public class SalesPersonControllerTest {

        private MockMvc mockMvc;

        @Autowired
        private SalesPersonService service;

         @Autowired
         private WebApplicationContext context;

        @Before
            public void setup() {
                mockMvc = MockMvcBuilders.webAppContextSetup(context)
                        .build();
            }


        @Test
        public void test() throws Exception
        {
            mockMvc.perform(get("/salesPerson/all"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json;charset=UTF-8"));
        }


}
