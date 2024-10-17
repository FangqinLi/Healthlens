package stevens.project.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
public class JUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIngredients() throws Exception {

        MockMultipartFile file = new MockMultipartFile("image", "src/main/resources/static/food.jpg", MediaType.IMAGE_JPEG_VALUE, getClass().getResourceAsStream("/static/food.jpg"));

        mockMvc.perform(multipart("/ingredients").file(file))
                .andExpect(status().isOk());
    }
    @Test
    public void testIngredients2() throws Exception {

        MockMultipartFile file = new MockMultipartFile("image", "src/main/resources/static/food2.jpg", MediaType.IMAGE_JPEG_VALUE, getClass().getResourceAsStream("/static/food2.jpg"));

        mockMvc.perform(multipart("/ingredients").file(file))
                .andExpect(status().isOk());
    }
}
