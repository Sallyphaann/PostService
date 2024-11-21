package fontys.sem6.circline.postservice.business;

import fontys.sem6.circline.postservice.domain.Post;
import fontys.sem6.circline.postservice.persistence.PostEntity;

import java.util.List;
import java.util.Optional;

public interface GetPostByUserIdUseCase {
    List<Post> getPostByUserId();
}
