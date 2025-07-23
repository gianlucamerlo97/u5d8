package gianlucamerlo.u5d8.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name="authors")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;


    public Author(String nome,String cognome,String email,LocalDate dataDiNascita,String avatar)
    {

        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.dataDiNascita=dataDiNascita;
        this.avatar=avatar;
    }
}
