package gianlucamerlo.u5d8.controllers;

import gianlucamerlo.u5d7.entities.Author;
import gianlucamerlo.u5d7.payloads.NewAuthorPayload;
import gianlucamerlo.u5d7.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    private AuthorsService authorsService;

    @GetMapping
    public List<Author> getAuthors(){
        return this.authorsService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody NewAuthorPayload body){
        return this.authorsService.saveAuthor(body);
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable int authorId){
        return this.authorsService.findById(authorId);
    }

    @PutMapping("/{authorId}")
    public Author findAuthorByIdAndUpdate(@PathVariable int authorId,@RequestBody NewAuthorPayload body){
         return this.authorsService.findByIdAndUpdate(authorId,body);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAuthorByIdAndDelete(@PathVariable int authorId)
    {
        this.authorsService.findByIdAndDelete(authorId);
    }
}
