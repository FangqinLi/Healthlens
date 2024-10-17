package stevens.project.spring;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class Controller {
    private static final String API_USER_TOKEN = "2657bb109c995bfda6b9dc2d8c1d54114c0b8f10";
    private static final String API_URL_DETECT = "https://api.logmeal.com/v2/image/segmentation/complete";
    private static final String API_URL_INGREDIENTS = "https://api.logmeal.com/v2/recipe/nutritionalInfo";

    @PostMapping("/detect")
    public ResponseEntity<?> detectDishes(@RequestParam("image") MultipartFile file) {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            headers.set("Authorization", "Bearer " + API_USER_TOKEN);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", new org.springframework.core.io.ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            });

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Map> response = restTemplate.exchange(
                    API_URL_DETECT,
                    HttpMethod.POST,
                    requestEntity,
                    Map.class
            );

            return ResponseEntity.ok(response.getBody().get("segmentation_results"));

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/ingredients")
    public ResponseEntity<?> detectIngredients(@RequestParam("image") MultipartFile file) {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            headers.set("Authorization", "Bearer " + API_USER_TOKEN);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", new org.springframework.core.io.ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            });

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Map> response = restTemplate.exchange(
                    API_URL_DETECT,
                    HttpMethod.POST,
                    requestEntity,
                    Map.class
            );

            String imageId = response.getBody().get("imageId").toString();

            HttpHeaders newHeaders = new HttpHeaders();
            newHeaders.set("Authorization", "Bearer " + API_USER_TOKEN);
            newHeaders.setContentType(MediaType.APPLICATION_JSON);

            String ingredientsJson = "{\"imageId\": \"" + imageId + "\"}";

            HttpEntity<String> ingredientsEntity = new HttpEntity<>(ingredientsJson, newHeaders);

            ResponseEntity<Map> ingredientsResponse = restTemplate.exchange(
                    API_URL_INGREDIENTS,
                    HttpMethod.POST,
                    ingredientsEntity,
                    Map.class
            );

            return ingredientsResponse;

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}
