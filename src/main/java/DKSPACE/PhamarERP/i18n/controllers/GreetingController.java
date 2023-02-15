package DKSPACE.PhamarERP.i18n.controllers;


import DKSPACE.PhamarERP.i18n.dto.GreetingDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ali Bouali
 */
@RestController
@RequestMapping("/api/v1/greetings")
@RequiredArgsConstructor
public class GreetingController {


  @PostMapping
  public ResponseEntity<String> postGreeting(
      @Valid @RequestBody GreetingDto greeting
  ) {
    return ResponseEntity.ok("ok");
  }

}
