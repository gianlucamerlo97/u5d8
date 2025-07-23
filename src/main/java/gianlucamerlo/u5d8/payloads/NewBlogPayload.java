package gianlucamerlo.u5d8.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewBlogPayload {

    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
}
