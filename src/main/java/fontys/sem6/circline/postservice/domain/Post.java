package fontys.sem6.circline.postservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private long id;
    private long userId;
    private String content;
    private Instant dateTime;;
}
