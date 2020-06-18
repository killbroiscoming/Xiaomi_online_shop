package com.xiaomi.test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springMVC.xml"})
@WebAppConfiguration    //Controller单元测试
public class WebTest {

    //声明一个模拟请求对象
    private MockMvc mockMvc;

    //需要一个web容器
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp(){

        //通过上下文环境，把mockMvc构建出来
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    public void testLogin() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/consumer/login/auth")
                .param("username", "lisa")
                .param("password", "123456")).andReturn();


        System.out.println(mvcResult.getResponse().getContentAsString());
    }


}
