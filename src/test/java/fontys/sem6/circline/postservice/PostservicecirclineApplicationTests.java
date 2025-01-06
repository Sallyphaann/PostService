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


import com.netflix.discovery.EurekaClient;
import fontys.sem6.circline.postservice.business.exception.UnauthorizedDataAccessException;
import fontys.sem6.circline.postservice.business.impl.CreatePostUseCaseImpl;
import fontys.sem6.circline.postservice.business.impl.DeletePostUseCaseImpl;
import fontys.sem6.circline.postservice.domain.AccessToken;
import fontys.sem6.circline.postservice.domain.CreatePostRequest;
import fontys.sem6.circline.postservice.domain.CreatePostResponse;
import fontys.sem6.circline.postservice.persistence.DatabaseSequence;
import fontys.sem6.circline.postservice.persistence.PostEntity;
import fontys.sem6.circline.postservice.persistence.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@SpringBootTest
class PostservicecirclineApplicationTests {
    @Test
    void contextLoads() {
    }

}


