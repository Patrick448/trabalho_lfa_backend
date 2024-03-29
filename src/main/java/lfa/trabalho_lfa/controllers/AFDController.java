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
@RequestMapping(value = "/afd")
@CrossOrigin
public class AFDController {

    public static class AFDRequest{
        public String afdDef;
        public String word;
    }

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

    @PostMapping(value="/test2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> test2(@RequestBody AFDRequest afdRequest){
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

    @PostMapping(value="/load-afd", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> loadAFD(@RequestBody String body, /*@CookieValue String user, */@RequestParam String uuid){
        AFD afd = new AFD();
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
    public ResponseEntity<Boolean> acceptsWord(@RequestParam String wordString,@RequestParam String uuid /*@CookieValue("user") String user*/){
        AFD afd = userData.get(uuid);
        Boolean aceita = afd.Aceita(wordString);
        System.out.println(uuid);
        System.out.println(wordString+ ". aceita: "+ aceita);
        return ResponseEntity.ok(aceita);
    }

    @GetMapping(value="/getDot")
    public ResponseEntity<String> generateDot(@RequestParam String uuid ){
        AFD afd = userData.get(uuid);
        return ResponseEntity.ok(afd.toDotLanguageString());
    }


    /*@GetMapping
    public ResponseEntity<List<ContratoDTO>> findAll(Pageable pageable){
        System.out.println("Returning contracts");

        List<ContratoDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value="/current-user")
    public ResponseEntity<List<ContratoDTO>> findAllCurrentUser(@AuthenticationPrincipal String username){
        System.out.println("Returning services of this user");
        List<ContratoDTO> list = service.findContractsByUserEmail(username);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/register",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity resgisterService(@RequestBody ContratoDTO contratoDTO, @AuthenticationPrincipal String username){

        Contrato contrato = new Contrato(contratoDTO);
        Usuario contratante = new Usuario(usuarioService.findById(contratoDTO.getContratanteId()));
        Usuario prestador = new Usuario(usuarioService.findById(contratoDTO.getPrestadorId()));
        Servico servico = new Servico(servicoService.findById(contratoDTO.getServicoId()));
        contrato.setContratante(contratante);
        contrato.setPrestador(prestador);
        contrato.setServico(servico);

        try {
            service.save(contrato);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().build();
    }*/


/*
    @PutMapping(value = "/register",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity resgisterService(@RequestBody ServicoDTO servicoDTO, @AuthenticationPrincipal String username){

        Servico servicoFromDTO = new Servico(servicoDTO);
        UsuarioDTO anuncianteDTO = usuarioService.findByEmail(username);
        servicoFromDTO.setAnunciante(new Usuario(anuncianteDTO));


        try {
            service.save(servicoFromDTO);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().build();
    }*/
}
