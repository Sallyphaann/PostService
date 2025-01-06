package fontys.sem6.circline.postservice.business.impl;

import fontys.sem6.circline.postservice.business.CreatePostUseCase;
import fontys.sem6.circline.postservice.domain.AccessToken;
import fontys.sem6.circline.postservice.domain.CreatePostRequest;
import fontys.sem6.circline.postservice.domain.CreatePostResponse;
import fontys.sem6.circline.postservice.persistence.DatabaseSequence;
import fontys.sem6.circline.postservice.persistence.PostEntity;
import fontys.sem6.circline.postservice.persistence.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.time.Instant;
import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@AllArgsConstructor
public class CreatePostUseCaseImpl implements CreatePostUseCase {
    private final PostRepository postRepository;
    private AccessToken requestAccessToken;

    private final MongoOperations mongoOperations;
    public long generateSequence(String seqName) {
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
    @Override
    public CreatePostResponse createPost(CreatePostRequest request) {
        PostEntity savedPost = PostEntity.builder()
                .id(generateSequence(PostEntity.SEQUENCE_NAME))
                .content(request.getContent())
                .userId(requestAccessToken.getUserId())
                .dateTime(Instant.now())
                .build();
        PostEntity savedPostEntity = postRepository.save(savedPost);

        return  CreatePostResponse.builder()
                .id(savedPostEntity.getId())
                .build();
    }

}
