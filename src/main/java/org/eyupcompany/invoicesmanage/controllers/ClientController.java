package org.eyupcompany.invoicesmanage.controllers;

import org.eyupcompany.invoicesmanage.dto.requests.ClientRequest;
import org.eyupcompany.invoicesmanage.dto.responses.ClientResponse;
import org.eyupcompany.invoicesmanage.models.ClientEntity;
import org.eyupcompany.invoicesmanage.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("")
    public ResponseEntity<List<ClientResponse>> clients(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ClientResponse add(@RequestBody ClientRequest clientRequest){
        return clientService.save(clientRequest);

    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<ClientResponse> edit(@RequestBody ClientRequest clientRequest,@PathVariable Long id){
        ClientResponse clientResponse=clientService.update(clientRequest,id);
        return ResponseEntity.accepted().body(clientResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> get(@PathVariable Long id){
        ClientResponse clientEntity=clientService.get(id);
        return ResponseEntity.ok(clientEntity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
