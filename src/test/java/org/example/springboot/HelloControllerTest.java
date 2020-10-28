package org.example.springboot;
import org.example.springboot.web.HelloController;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) /*스프링 부트테스트와 JUnit 사이 연결자 역할*/
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired /*의존성 주입*/
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        /*/hello로 http Get 요청*/
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())  /*status 200 유무 체크*/
                .andExpect(content().string(hello));
    }
}
