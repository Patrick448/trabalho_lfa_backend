package lfa.trabalho_lfa.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping(value="/create-uuid")
    public ResponseEntity<String> createUUID(HttpServletResponse response, @CookieValue(value = "user", required = false) String user){
        System.out.println("Create UUID");

        if(user == null){
            UUID uuid = UUID.randomUUID();
            Cookie cookie = new Cookie("user", uuid.toString());
            cookie.setMaxAge(7*24*60*60);
            response.addCookie(cookie);
        }

        return ResponseEntity.ok("Create uuid");
    }
}
