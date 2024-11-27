package com.sambit.Controller;

import com.sambit.Entity.Post;
import com.sambit.Repositry.CommentRepository;
import com.sambit.Repositry.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private PostRepository postRepository;
    private CommentRepository commentRepository;


    public PostController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    @PostMapping
    public String createpost(
            @RequestBody Post post
            ){

        postRepository.save(post);
        return "saved";

    }

    @DeleteMapping
     public void deletepost(){
        postRepository.deleteById(1l);
    }
}
