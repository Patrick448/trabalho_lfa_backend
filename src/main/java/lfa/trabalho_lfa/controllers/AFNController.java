package lfa.trabalho_lfa.controllers;


import lfa.trabalho_lfa.afds.AFD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/afn")
public class AFNController {


    private HashMap<String, AFD> userData = new HashMap<String, AFD>();

    @GetMapping(value="/test")
    public ResponseEntity<String> test(){
        System.out.println("Test");
        return ResponseEntity.ok("Testando 1 2 3");
    }

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

    @GetMapping(value="/test4")
    public ResponseEntity<String> test4(HttpServletResponse response){
        System.out.println("Test4");
        Cookie cookie = new Cookie("user", "1");
        cookie.setMaxAge(7*24*60*60);
        response.addCookie(cookie);

        return ResponseEntity.ok("Testando 1 2 3");
    }


    @PostMapping(value="/load-afd", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> loadAFD(@RequestBody String body, @CookieValue String user){
        AFD afd = new AFD();
        try {
            afd.lerString(body);
            userData.put(user, afd);
            userData.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        System.out.println("Test");
        return ResponseEntity.ok(afd.toString());
    }

    @GetMapping(value="/accepts/{word}")
    public ResponseEntity<Boolean> acceptsWord(@PathVariable String word, @CookieValue("user") String user){
        AFD afd = userData.get(user);
        Boolean aceita = afd.Aceita(word);
        System.out.println(user);
        System.out.println(word+ ". aceita: "+ aceita);
        return ResponseEntity.ok(aceita);
    }


}
