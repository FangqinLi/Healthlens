package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestController.class)
@Import(SecurityConfiguration.class)
public class UnitTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIngredients() throws Exception {
        MockMultipartFile file = new MockMultipartFile("image", "src/main/resources/static/food.jpg", MediaType.IMAGE_JPEG_VALUE, getClass().getResourceAsStream("/static/food.jpg"));

        mockMvc.perform(multipart("/detect").file(file)
                        .with(SecurityMockMvcRequestPostProcessors.oauth2Login())
                        .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isOk());
    }
}
