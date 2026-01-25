package com.yanferreira.workshopmongo.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yanferreira.workshopmongo.domain.Post;
import com.yanferreira.workshopmongo.resources.util.URL;
import com.yanferreira.workshopmongo.services.PostService;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById (@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = service.findByTitle(text);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
        @RequestParam(value = "text", defaultValue = "") String text,
        @RequestParam(value = "minDate", defaultValue = "") String minDate,
        @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ) {
        text = URL.decodeParam(text);
        LocalDate minDateFormatted = URL.convertDate(minDate, LocalDate.ofEpochDay(0L));
        LocalDate maxDateFormatted = URL.convertDate(maxDate, LocalDate.now());
        List<Post> posts = service.fullSearch(text, minDateFormatted, maxDateFormatted);
        return ResponseEntity.ok(posts);
    }
    
    
}
