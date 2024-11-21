package fontys.sem6.circline.postservice.business.impl;

import fontys.sem6.circline.postservice.domain.Post;
import fontys.sem6.circline.postservice.persistence.PostEntity;

final class PostConverter {
    public PostConverter(){

    }
    public static Post convert(PostEntity post) {
        return Post.builder()
                .id(post.getId())
                .content(post.getContent())
                .userId(post.getUserId())
                .dateTime(post.getDateTime())
                .build();
    }
}
