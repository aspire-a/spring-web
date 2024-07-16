package yte.intern.spring_web.sendHTTPrequest;

import org.junit.jupiter.api.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

public class RestTemplateTest {

    @Test
    public void getAllPosts() {

        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder
                .fromHttpUrl("https://jsonplaceholder.typicode.com/")
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Void> request = RequestEntity.get(uri).build();
        ResponseEntity<Post[]> response = restTemplate.exchange(request, Post[].class);

        System.out.println(Arrays.stream(response.getBody()).toList());
    }


    @Test
    public void getPostsWithID2() {

        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder
                .fromHttpUrl("https://jsonplaceholder.typicode.com/")
                .pathSegment("posts")
                .pathSegment("2")
                .build()
                .toUri();

        RequestEntity<Void> request = RequestEntity.get(uri).build();

        ResponseEntity<Post> response = restTemplate.exchange(request, Post.class);

        System.out.println(response.getBody());
    }



    @Test
    public void addRandomPost() {

        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder
                .fromHttpUrl("https://jsonplaceholder.typicode.com/")
                .pathSegment("posts")
                .build()
                .toUri();

        Post newPost = new Post((long)123, (long)456, "Title bu", "Bu da Body");

        RequestEntity<Post> request = RequestEntity.post(uri).body(newPost);

        ResponseEntity<Post> response = restTemplate.exchange(request, Post.class);

        System.out.println(response.getBody());
    }



    @Test
    public void getPostsWithUserID2() {

        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder
                .fromHttpUrl("https://jsonplaceholder.typicode.com/")
                .pathSegment("posts")
                .queryParam("userID", 2)
                .build()
                .toUri();

        RequestEntity<Void> request = RequestEntity.get(uri).build();

        ResponseEntity<Post[]> response = restTemplate.exchange(request, Post[].class);

        System.out.println(Arrays.stream(response.getBody()).toList());
    }




    @Test
    public void updateCommentWithId5() {

        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder
                .fromHttpUrl("https://jsonplaceholder.typicode.com/")
                .pathSegment("comments")
                .pathSegment("5")
                .build()
                .toUri();


        Comment newComment = new Comment((long)456, (long)123, "Name", "Email", "Body");

        RequestEntity<Comment> request = RequestEntity.put(uri).body(newComment);

        ResponseEntity<Comment> response = restTemplate.exchange(request, Comment.class);

        System.out.println(response.getBody());
    }


    @Test
    public void deletepostWithId1() {

        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder
                .fromHttpUrl("https://jsonplaceholder.typicode.com/")
                .pathSegment("posts")
                .pathSegment("1")
                .build()
                .toUri();


        RequestEntity<Void> request = RequestEntity.delete(uri).build();

        ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);

        System.out.println(response.getStatusCode());
    }
}
