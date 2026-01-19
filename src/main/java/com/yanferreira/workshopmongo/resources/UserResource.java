package com.yanferreira.workshopmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yanferreira.workshopmongo.domain.User;
import com.yanferreira.workshopmongo.dto.UserDto;
import com.yanferreira.workshopmongo.services.UserService;



@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(u -> new UserDto(u)).toList();
        return ResponseEntity.ok(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok(new UserDto(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDto objUserDto) {
        User objUser = service.fromDto(objUserDto);
        objUser = service.insert(objUser);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    
}
