package gianlucamerlo.u5d8.exceptions;

import gianlucamerlo.u5d8.payloads.ErrorsPayload;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class ExceptionsHandler {

   @ExceptionHandler(BadRequestException.class) // Tra le parentesi indico quale eccezione dovrà gestire questo metodo
   @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
   public ErrorsPayload handleBadRequest(BadRequestException ex) {
      return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
   }

   @ExceptionHandler(NotFoundException.class)
   @ResponseStatus(HttpStatus.NOT_FOUND) // 404
   public ErrorsPayload handleNotFound(NotFoundException ex) {
      return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
   }

   @ExceptionHandler(Exception.class) // Tutte le eccezioni non gestite dagli altri metodi risulteranno essere un Server Error (500)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
   public ErrorsPayload handleServerError(Exception ex) {
      ex.printStackTrace(); // E' importante avere il print dello stack trace per avere un'indicazione utile per debuggare/fixare l'errore
      return new ErrorsPayload("C'è stato un errore generico! Giuro che lo risolveremo presto!", LocalDateTime.now());
   }
}
