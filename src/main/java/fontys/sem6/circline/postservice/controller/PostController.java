package fontys.sem6.circline.postservice.controller;

import fontys.sem6.circline.postservice.business.*;
import fontys.sem6.circline.postservice.domain.*;
import fontys.sem6.circline.postservice.security.isauthenticated.IsAuthenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final CreatePostUseCase createPostUseCase;
    private final GetPostsUseCase getPostsUseCase;
    private final UpdatePostUseCase updatePostUseCase;
    private final DeletePostUseCase deletePostUseCase;
    private final GetPostByUserIdUseCase getPostByUserId;

    @IsAuthenticated
    @RolesAllowed({"USER"})
    @PostMapping()
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody @Valid CreatePostRequest request) {
        CreatePostResponse response = createPostUseCase.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping()
    public ResponseEntity<GetAllPostsResponse> getPosts() {
        return ResponseEntity.ok(getPostsUseCase.getPosts());
    }
    @IsAuthenticated
    @RolesAllowed({"USER"})
    @PutMapping("{id}")
    public ResponseEntity<Void> updatePost(@PathVariable("id") long id,
                                           @RequestBody @Valid UpdatePostRequest request) {
        request.setId(id);
        updatePostUseCase.updatePost(request);
        return ResponseEntity.noContent().build();
    }
    @IsAuthenticated
    @RolesAllowed({"USER"})
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePost(@PathVariable long id) {
        deletePostUseCase.deletePost(id);
        return ResponseEntity.noContent().build();
    }
    @IsAuthenticated
    @RolesAllowed({"USER"})
    @GetMapping("/mine")
    public ResponseEntity<List<Post>> getPostsByUserId() {

        return ResponseEntity.ok(getPostByUserId.getPostByUserId());
    }

}
