package gianlucamerlo.u5d8.services;

import gianlucamerlo.u5d8.entities.Author;
import gianlucamerlo.u5d8.exceptions.NotFoundException;
import gianlucamerlo.u5d8.payloads.NewAuthorPayload;
import gianlucamerlo.u5d8.repositories.AuthorsRepository;
import lombok.extern.slf4j.Slf4j;
import gianlucamerlo.u5d8.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class AuthorsService {

    @Autowired
    private AuthorsRepository authorsRepository;

    public List<Author>findAll(){
        return this.authorsRepository.findAll();
    }

    public Author saveAuthor(NewAuthorPayload payload)
    {
        this.authorsRepository.findByEmail(payload.getEmail()).ifPresent(author -> {throw new BadRequestException("L'email "+author.getEmail()+" è già in uso!");
        });

        Author newAuthor=new Author(payload.getNome(), payload.getCognome(),payload.getEmail(),payload.getDataDiNascita(),"https://ui-avatars.com/api/?name=" + payload.getNome() + "+" + payload.getCognome());

        Author savedAuthor=this.authorsRepository.save(newAuthor);

        log.info("L'autore con email "+payload.getEmail()+" è stato salvato correttamente!");
        return savedAuthor;
    }

    public Author findById(UUID authorId){
        return this.authorsRepository.findById(authorId).orElseThrow(()->new NotFoundException(authorId));
    }

    public Author findByIdAndUpdate(UUID authorId,NewAuthorPayload payload){
        Author found =this.findById(authorId);
        if (!found.getEmail().equals(payload.getEmail()))
        this.authorsRepository.findByEmail(payload.getEmail()).ifPresent(author -> {throw new BadRequestException ("L'email "+author.getEmail()+" è già in uso!");
        });

        return found;
    }

//    public void findByIdAndDelete(UUID authorId){
//        Author found=null;
//        for(Author author:this.authorsDB)
//        {
//            if(author.getId()==authorId) found=author;
//        }
//
//        if (found==null) throw new NotFoundException(authorId);
//        this.authorsDB.remove(found);
//    }


}
