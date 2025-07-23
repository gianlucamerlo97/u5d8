package gianlucamerlo.u5d8.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;
import java.util.UUID;

@Entity
@Table(name="blogs")
@Getter
@Setter
@ToString
public class Blog {
    @Id
    @GeneratedValue
    private UUID id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

public Blog(String categoria,String titolo,String cover,String contenuto,int tempoDiLettura)
{
    
    this.categoria=categoria;
    this.titolo=titolo;
    this.cover=cover;
    this.contenuto=contenuto;
    this.tempoDiLettura=tempoDiLettura;

}
}
