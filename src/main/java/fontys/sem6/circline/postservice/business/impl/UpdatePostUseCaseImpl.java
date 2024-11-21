package fontys.sem6.circline.postservice.business.impl;

import fontys.sem6.circline.postservice.business.UpdatePostUseCase;
import fontys.sem6.circline.postservice.business.exception.UnauthorizedDataAccessException;
import fontys.sem6.circline.postservice.domain.AccessToken;
import fontys.sem6.circline.postservice.domain.UpdatePostRequest;
import fontys.sem6.circline.postservice.persistence.PostEntity;
import fontys.sem6.circline.postservice.persistence.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdatePostUseCaseImpl implements UpdatePostUseCase {
    private final PostRepository postRepository;
    private final AccessToken requestAccessToken;
    @Override
    public void updatePost(UpdatePostRequest request) {
        Optional<PostEntity> postOptional = postRepository.findById(request.getId());

           if (!Objects.equals(requestAccessToken.getUserId(), postOptional.get().getUserId())) {
               throw new UnauthorizedDataAccessException("USER_ID_NOT_FROM_LOGGED_IN_USER");
           }
        PostEntity post = postOptional.get();
        post.setContent(request.getContent());
        post.setDateTime(Instant.now());
        postRepository.save(post);
    }
}
