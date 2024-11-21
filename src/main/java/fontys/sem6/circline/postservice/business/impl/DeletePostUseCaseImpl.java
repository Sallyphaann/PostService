package fontys.sem6.circline.postservice.business.impl;

import fontys.sem6.circline.postservice.business.DeletePostUseCase;
import fontys.sem6.circline.postservice.persistence.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeletePostUseCaseImpl implements DeletePostUseCase {
    private final PostRepository postRepository;
    @Override
    public void deletePost(long id) {
        this.postRepository.deleteById(id);
    }
}
