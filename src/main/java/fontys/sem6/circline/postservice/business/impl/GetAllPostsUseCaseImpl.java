package fontys.sem6.circline.postservice.business.impl;

import fontys.sem6.circline.postservice.business.GetPostsUseCase;
import fontys.sem6.circline.postservice.domain.GetAllPostsResponse;
import fontys.sem6.circline.postservice.domain.Post;
import fontys.sem6.circline.postservice.persistence.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllPostsUseCaseImpl implements GetPostsUseCase {
    private final PostRepository postRepository;
    @Override
    public GetAllPostsResponse getPosts() {
        List<Post> posts = postRepository.findAll()
                .stream()
                .map(PostConverter::convert)
                .toList();

        return GetAllPostsResponse.builder()
                .posts(posts).build();
    }
}
