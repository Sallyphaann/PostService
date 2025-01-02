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
import org.json.JSONException;
import org.json.JSONObject;
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
import org.springframework.web.client.RestTemplate;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostservicecirclineApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest
//@AutoConfigureMockMvc
//class PostservicecirclineApplicationTests {
//    @Test
//    void contextLoads() {
//    }

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
//    @Test
//    public void testAuthenticationServiceCreatePost() {
//        String authServiceUrl = "http://localhost:9091/login";
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
//
//        String postServiceUrl = "http://localhost:9090/posts";
//        String createPostRequestBody = "{\"content\": \"this is the test content\"}";
//        HttpHeaders postHeaders = new HttpHeaders();
//        postHeaders.set("Authorization", "Bearer " + token);
//        postHeaders.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> createPostEntity = new HttpEntity<>(createPostRequestBody, postHeaders);
//        ResponseEntity<String> response1 = restTemplate.exchange(postServiceUrl, HttpMethod.POST, createPostEntity, String.class);
//        assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//        String id = null;
//        try {
//            JSONObject jsonResponse = new JSONObject(response1.getBody());
//            id = jsonResponse.getString("id");
//        } catch (JSONException e) {
//
//            fail("Error parsing id response: " + e.getMessage());
//        }
//        assertThat(id).isNotNull();
//
//    }
}


