package fontys.sem6.circline.postservice.business.impl;

import fontys.sem6.circline.postservice.business.DeletePostUseCase;
import fontys.sem6.circline.postservice.business.exception.UnauthorizedDataAccessException;
import fontys.sem6.circline.postservice.domain.AccessToken;
import fontys.sem6.circline.postservice.persistence.PostEntity;
import fontys.sem6.circline.postservice.persistence.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeletePostUseCaseImpl implements DeletePostUseCase {
    private final PostRepository postRepository;
    private final AccessToken requestAccessToken;
    @Override
    public void deletePost(long id) {
        Optional<PostEntity> post = postRepository.findById(id);
        if(post.get().getUserId() != requestAccessToken.getUserId()){
            throw new UnauthorizedDataAccessException("USER_ID_NOT_FROM_LOGGED_IN_USER");
        }
        this.postRepository.deleteById(id);
    }
}
