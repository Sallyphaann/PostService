package fontys.sem6.circline.postservice.business;

import fontys.sem6.circline.postservice.domain.CreatePostRequest;
import fontys.sem6.circline.postservice.domain.CreatePostResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


public interface CreatePostUseCase  {
    CreatePostResponse createPost(CreatePostRequest request);
}
