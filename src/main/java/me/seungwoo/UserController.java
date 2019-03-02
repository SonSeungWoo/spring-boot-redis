package me.seungwoo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Leo.
 * User: sonseungwoo
 * Date: 2019-03-01
 * Time: 21:47
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getUserList(){
        log.info("=========getUserList===========");
        return userRepository.findAll();
    }


    @PostMapping("/user")
    public void saveUser(@RequestBody User user){
        userRepository.save(user);
    }
}
