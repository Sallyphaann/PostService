package fontys.sem6.circline.postservice.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;
@Document(collection = "postservice")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    @Transient
    public static final String SEQUENCE_NAME = "posts_sequence";
    @Id
    private long id;
    private long userId;
    private String content;
    private Instant dateTime;
}
