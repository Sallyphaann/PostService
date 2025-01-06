package fontys.sem6.circline.postservice.business.impl;

import fontys.sem6.circline.postservice.business.exception.UnauthorizedDataAccessException;
import fontys.sem6.circline.postservice.domain.AccessToken;
import fontys.sem6.circline.postservice.persistence.PostEntity;
import fontys.sem6.circline.postservice.persistence.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeletePostUseCaseImplTest {
    @Mock
    private PostRepository postRepository;
    @InjectMocks
    private DeletePostUseCaseImpl deletePostUseCase;
    @Mock
    private AccessToken requestAccessToken;
    @Test
    void deletePost_UnauthorizedAccess() {
        PostEntity post = PostEntity.builder()
                .id(1L)
                .userId(1L)
                .content("test")
                .dateTime(Instant.now())
                .build();
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(requestAccessToken.getUserId()).thenReturn(2L);
        assertThrows(UnauthorizedDataAccessException.class, () -> {
            deletePostUseCase.deletePost(1L);
        });
    }
    @Test
    void deletePost() {

        PostEntity post = PostEntity.builder()
                .id(1L)
                .userId(2L)
                .content("test")
                .dateTime(Instant.now())
                .build();

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(requestAccessToken.getUserId()).thenReturn(2L);

        deletePostUseCase.deletePost(1L);

        // Assert: Verify that deleteById was called once on the repository
        verify(postRepository).deleteById(1L);
    }
    }

