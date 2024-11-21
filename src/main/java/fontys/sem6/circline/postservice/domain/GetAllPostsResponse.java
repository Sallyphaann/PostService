package fontys.sem6.circline.postservice.domain;

import fontys.sem6.circline.postservice.persistence.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllPostsResponse {
    List<Post> posts;
}
