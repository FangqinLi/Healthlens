package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    //    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private OAuth2AuthorizedClientService authorizedClientService;
//
    private final RestTemplate restTemplate;
    RestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String apiKey = "AIzaSyDBMn2wa3fOhKFYeeFZur9EF82fa17iX58";

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttributes().get("name"));
    }

    @PostMapping("/detect")
    public ResponseEntity<?> recognizeFood(@RequestParam("image") MultipartFile image) throws IOException {
//        OAuth2AuthorizedClient client = this.authorizedClientService.loadAuthorizedClient("google", authentication.getName());
//        OAuth2AccessToken token = client.getAccessToken();

        String base64Image = Base64.getEncoder().encodeToString(image.getBytes());

        String requestBody = String.format(
                "{\"requests\":[{\"image\":{\"content\":\"%s\"},\"features\":[{\"type\":\"LABEL_DETECTION\",\"maxResults\":10}]}]}",
                base64Image
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        String apiUrl = String.format("https://vision.googleapis.com/v1/images:annotate?key=%s", apiKey);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

        return ResponseEntity.ok(response.getBody());
    }
}

//@Value("${apiKey}")
//private String API_USER_TOKEN;
//private static final String API_URL_DETECT = "https://api.logmeal.com/v2/image/segmentation/complete";
//private static final String API_URL_INGREDIENTS = "https://api.logmeal.com/v2/recipe/nutritionalInfo";
//
//@PostMapping("/detect")
//public ResponseEntity<?> detectDishes(@RequestParam("image") MultipartFile file) {
//    try {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        headers.set("Authorization", "Bearer " + API_USER_TOKEN);
//
//        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//        body.add("image", new org.springframework.core.io.ByteArrayResource(file.getBytes()) {
//            @Override
//            public String getFilename() {
//                return file.getOriginalFilename();
//            }
//        });
//
//        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
//
//        ResponseEntity<Map> response = restTemplate.exchange(
//                API_URL_DETECT,
//                HttpMethod.POST,
//                requestEntity,
//                Map.class
//        );
//
//        return ResponseEntity.ok(response.getBody().get("segmentation_results"));
//
//    } catch (Exception e) {
//        return ResponseEntity.status(500).body("Error: " + e.getMessage());
//    }
//}

//@PostMapping("/ingredients")
//public ResponseEntity<?> detectIngredients(@RequestParam("image") MultipartFile file) {
//    try {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        headers.set("Authorization", "Bearer " + API_USER_TOKEN);
//
//        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//        body.add("image", new org.springframework.core.io.ByteArrayResource(file.getBytes()) {
//            @Override
//            public String getFilename() {
//                return file.getOriginalFilename();
//            }
//        });
//
//        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Map> response = restTemplate.exchange(
//                API_URL_DETECT,
//                HttpMethod.POST,
//                requestEntity,
//                Map.class
//        );
//
//        String imageId = response.getBody().get("imageId").toString();
//
//        HttpHeaders newHeaders = new HttpHeaders();
//        newHeaders.set("Authorization", "Bearer " + API_USER_TOKEN);
//        newHeaders.setContentType(MediaType.APPLICATION_JSON);
//
//        String ingredientsJson = "{\"imageId\": \"" + imageId + "\"}";
//
//        HttpEntity<String> ingredientsEntity = new HttpEntity<>(ingredientsJson, newHeaders);
//
//        ResponseEntity<Map> ingredientsResponse = restTemplate.exchange(
//                API_URL_INGREDIENTS,
//                HttpMethod.POST,
//                ingredientsEntity,
//                Map.class
//        );
//
//        return ResponseEntity.ok(ingredientsResponse.getBody());
//
//    } catch (Exception e) {
//        return ResponseEntity.status(500).body("Error: " + e.getMessage());
//    }
//}