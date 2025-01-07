package fontys.sem6.circline.postservice.testing;

import fontys.sem6.circline.postservice.test.JwtTokenUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PostServiceCircIineIntegrationTests {
    @LocalServerPort
    private int port;
    private RestTemplate restTemplate;  
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    private String adminToken;
    private String userToken;

    @BeforeEach
    public void setUp() {
        restTemplate = new RestTemplate();  // Initialize RestTemplate manually
        adminToken = jwtTokenUtil.generateMockToken(1L, "Admin@gmail.com", "ADMIN");  // Use correct ID and email format
        userToken = jwtTokenUtil.generateMockToken(2L, "User@gmail.com", "USER");    // Use consistent and meaningful data
    }
    @Test
    void testCreatePostAsUser() {
        String postJson ="{\"content\": \"This is test content\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + userToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(postJson, headers);
        String url = "http://localhost:" + port + "/posts";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
    //    @Test
//    void testCreatePostAsAdmin() {
//        String createPostRequestBody = "{\"content\": \"This is test content\"}";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + userToken);
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<String> requestEntity = new HttpEntity<>(createPostRequestBody, headers);
//        ResponseEntity<String> response = restTemplate.exchange(postServiceUrl, HttpMethod.POST, requestEntity, String.class);
//
//        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
//        assertThat(response.getBody()).contains("id");
//    }


}
