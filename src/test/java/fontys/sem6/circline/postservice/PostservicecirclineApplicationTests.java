//package fontys.sem6.circline.postservice;
//
//import org.junit.jupiter.api.Test;
//
//class PostservicecirclineApplicationTests {
//
//    @Test
//    void contextLoads() {
//    }
//
//}
package fontys.sem6.circline.postservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fontys.sem6.circline.postservice.persistence.PostEntity;
import fontys.sem6.circline.postservice.test.JwtTokenUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest
//@ActiveProfiles("test")
//@Transactional
//@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PostservicecirclineApplicationTests {
    @LocalServerPort
    private int port;
    private RestTemplate restTemplate;  // Manually instantiate RestTemplate

    private String adminToken;
    private String userToken;

    @BeforeEach
    public void setUp() {
        restTemplate = new RestTemplate();  // Initialize RestTemplate manually
        adminToken = JwtTokenUtil.generateMockToken(1L, "Admin@gmail.com", "ADMIN");  // Use correct ID and email format
        userToken = JwtTokenUtil.generateMockToken(2L, "User@gmail.com", "USER");    // Use consistent and meaningful data
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
    @Test
    void contextLoads() {
   }

//
//    @Value("${local.server.port}")
//    private int postServicePort;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    @Test
//    public void testAuthenticationServiceLogin() {
//        String authServiceUrl = "http://localhost:8081/login";
//        String loginRequestBody = "{\"email\": \"Sally@gmail.com\", \"password\": \"Abc@12\"}";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<String> entity = new HttpEntity<>(loginRequestBody, headers);
//        ResponseEntity<String> response = restTemplate.exchange(authServiceUrl, HttpMethod.POST, entity, String.class);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//        String token = null;
//        try {
//            JSONObject jsonResponse = new JSONObject(response.getBody());
//            token = jsonResponse.getString("accessToken");
//        } catch (JSONException e) {
//            System.err.println("Error parsing JSON response or accessing token: " + e.getMessage());
//            fail("Error parsing JSON response: " + e.getMessage());
//        }
//        String postServiceUrl = "http://localhost:8082/posts/mine";
//        HttpHeaders postHeaders = new HttpHeaders();
//        postHeaders.set("Authorization", "Bearer " + token);
//        HttpEntity<String> getEntity = new HttpEntity<>(postHeaders);
//        ResponseEntity<String> response1 = restTemplate.exchange(postServiceUrl, HttpMethod.GET, getEntity, String.class);
//        assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//    }
//

}


