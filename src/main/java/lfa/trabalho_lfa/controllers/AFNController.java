package lfa.trabalho_lfa.controllers;


import lfa.trabalho_lfa.afds.AFD;
import lfa.trabalho_lfa.afds.AFN;
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
@CrossOrigin
public class AFNController {


    private HashMap<String, AFN> userData = new HashMap<String, AFN>();

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

    @PostMapping(value="/test2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> test2(@RequestBody AFDController.AFDRequest afdRequest){
        AFD a = new AFD();
        try {
            a.lerString(afdRequest.afdDef);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        System.out.println("Test");
        return ResponseEntity.ok(a.toString() + "\n Aceita: " + a.Aceita(afdRequest.word));
    }

    @PostMapping(value="/load-afn", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> loadAFD(@RequestBody String body, /*@CookieValue String user, */@RequestParam String uuid){
        AFN afd = new AFN();
        try {
            afd.lerString(body);
            userData.put(uuid, afd);
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

    @GetMapping(value="/accepts")
    public ResponseEntity<Boolean> acceptsWord(@RequestParam String word,@RequestParam String uuid /*@CookieValue("user") String user*/){
        AFN afd = userData.get(uuid);
        Boolean aceita = afd.Aceita(word);
        System.out.println(uuid);
        System.out.println(word+ ". aceita: "+ aceita);
        return ResponseEntity.ok(aceita);
    }


}
