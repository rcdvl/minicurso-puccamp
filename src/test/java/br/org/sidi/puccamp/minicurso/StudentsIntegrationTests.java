package br.org.sidi.puccamp.minicurso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentsIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAddAndListStudents() throws Exception {
        MockHttpServletRequestBuilder addRequest = post("/students")
                .param("fullName", "Test Student");

        mockMvc.perform(addRequest)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/students"));

        // preencher com get para /students esperando uma resposta contendo "Test Student"
    }
}
