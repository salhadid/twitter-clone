package com.cooksys.team1assess1.controllers;

import com.cooksys.team1assess1.dtos.CredentialsDto;
import com.cooksys.team1assess1.dtos.TweetResponseDto;
import com.cooksys.team1assess1.dtos.UserRequestDto;
import com.cooksys.team1assess1.dtos.UserResponseDto;
import com.cooksys.team1assess1.entities.Credentials;
import com.cooksys.team1assess1.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/@{username}/feed")
    public List<TweetResponseDto> GetUserFeed(@PathVariable String username){
        return userService.getUserFeed(username);
    }
    @GetMapping("/@{username}/mentions")
    public List<TweetResponseDto> GetUserMentions(@PathVariable String username){
        return userService.getUserMentions(username);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto user) {
        return userService.createUser(user);
    }

    @PatchMapping("/@{username}")
    public UserResponseDto updateProfile(@RequestBody UserRequestDto user, @PathVariable String username) {
        return userService.updateProfile(user, username);
    }

    @DeleteMapping("/@{username}")
    public UserResponseDto deleteUser(@RequestBody CredentialsDto credentialsDto, @PathVariable String username) {
        return userService.deleteUser(credentialsDto, username);
    }

    @GetMapping("/@{username}/followers")
    public List<UserResponseDto> getUserFollowers(@PathVariable String username) {
        return userService.getUserFollowers(username);
    }

    @GetMapping("/@{username}/following")
    public List<UserResponseDto> getUserFollowing(@PathVariable String username) {
        return userService.getUserFollowing(username);
    }

    @GetMapping("/@{username}/tweets")
    public List<TweetResponseDto> getUserTweets(@PathVariable String username) {
        return userService.getUserTweets(username);
    }

    @PostMapping("/@{username}/follow")
    public void follow(@RequestBody Credentials credentials, @PathVariable String username) {
        userService.follow(credentials, username);
    }

    @PostMapping("/@{username}/unfollow")
    public void unfollow(@RequestBody Credentials credentials, @PathVariable String username) {
        userService.unfollow(credentials, username);
    }

    @GetMapping("/@{username}")
    public UserResponseDto getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

}
