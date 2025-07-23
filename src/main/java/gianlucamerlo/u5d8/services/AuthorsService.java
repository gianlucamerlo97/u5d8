package gianlucamerlo.u5d8.services;

import gianlucamerlo.u5d7.entities.Author;
import gianlucamerlo.u5d7.exceptions.NotFoundException;
import gianlucamerlo.u5d7.payloads.NewAuthorPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class AuthorsService {

    private List<Author> authorsDB=new ArrayList<>();

    public List<Author>findAll(){
        return this.authorsDB;
    }

    public Author saveAuthor(NewAuthorPayload payload)
    {
        Author newAuthor=new Author(payload.getNome(), payload.getCognome(), payload.getEmail(),payload.getDataDiNascita(),"https://ui-avatars.com/api?name=Mario+Rossi");
        this.authorsDB.add(newAuthor);

        log.info("L'autore con email "+payload.getEmail()+" è stato salvato correttamente!");
        return newAuthor;
    }

    public Author findById(int authorId){
        Author found=null;
                for(Author author:this.authorsDB)
                {
                    if(author.getId()==authorId) found=author;
                }

                if (found==null) throw new NotFoundException(authorId);
                return found;
    }

    public Author findByIdAndUpdate(int authorId,NewAuthorPayload payload){
        Author found =null;
        for(Author author:this.authorsDB)
        {
            if(author.getId()==authorId){
                found=author;
                found.setNome(payload.getNome());
                found.setCognome(payload.getCognome());
                found.setEmail(payload.getEmail());
                found.setDataDiNascita(payload.getDataDiNascita());
            }
        }
        if (found==null) throw new NotFoundException(authorId);
        return found;
    }

    public void findByIdAndDelete(int authorId){
        Author found=null;
        for(Author author:this.authorsDB)
        {
            if(author.getId()==authorId) found=author;
        }

        if (found==null) throw new NotFoundException(authorId);
        this.authorsDB.remove(found);
    }


}
