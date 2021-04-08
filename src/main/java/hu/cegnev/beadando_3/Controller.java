package hu.cegnev.beadando_3;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PostMapping("/megfordit")
    public SimpleResponse Megfordit (@RequestBody SimpleResponse forditando) {
        if (forditando.getContent()=="") //vagy esetleg null
        {
            return SimpleResponse.builder().content("ttala af a amlA").build();
        }
        else
        {
            StringBuilder forditas = new StringBuilder(forditando.getContent());
            return SimpleResponse.builder().content(forditas.reverse().toString()).build();
        }

    }

    @GetMapping(path= "/")
    public SimpleResponse Udvozles(@RequestParam(required = false) String name){
        if (name== null)
        {
            return  SimpleResponse.builder().content("Hello Felhasznalo!").build();
        }
        else
        {
            return  SimpleResponse.builder().content("Hello " + name + "!").build();
        }

    }
}
