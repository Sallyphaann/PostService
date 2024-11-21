package fontys.sem6.circline.postservice.business.impl;

import fontys.sem6.circline.postservice.business.GetPostByUserIdUseCase;
import fontys.sem6.circline.postservice.business.exception.UnauthorizedDataAccessException;
import fontys.sem6.circline.postservice.domain.AccessToken;
import fontys.sem6.circline.postservice.domain.Post;
import fontys.sem6.circline.postservice.persistence.PostEntity;
import fontys.sem6.circline.postservice.persistence.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetPostByUserIdUseCaseImpl implements GetPostByUserIdUseCase {
    private final PostRepository postRepository;
    private final AccessToken requestAccessToken;
    @Override
    public List<Post> getPostByUserId() {
        List<PostEntity> posts = postRepository.findByUserId(requestAccessToken.getUserId());

        return posts.stream()
                .map(PostConverter::convert)
                .collect(Collectors.toList());
    }
}
