package fontys.sem6.circline.postservice.business;

import fontys.sem6.circline.postservice.domain.GetAllPostsResponse;

public interface GetPostsUseCase {
    GetAllPostsResponse getPosts();
}
