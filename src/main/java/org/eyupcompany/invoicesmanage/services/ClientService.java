package org.eyupcompany.invoicesmanage.services;

import org.eyupcompany.invoicesmanage.dao.Client;
import org.eyupcompany.invoicesmanage.dao.User;
import org.eyupcompany.invoicesmanage.dto.requests.ClientRequest;
import org.eyupcompany.invoicesmanage.dto.responses.ClientResponse;
import org.eyupcompany.invoicesmanage.exceptions.EntityNotFoundException;
import org.eyupcompany.invoicesmanage.models.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("ClientService")
public class ClientService {
    private Client client;
    private UserService userService;
    private ModelMapper modelMapper;
    private User user;
    public ClientService(ModelMapper modelMapper, Client client,UserService userService){
        this.modelMapper=modelMapper;
        this.client =client;
        this.userService= userService;
    }
    /* save a new client  */

    public ClientResponse save(ClientRequest clientRequest){
        ClientEntity clientEntity= modelMapper.map(clientRequest,ClientEntity.class);
        /* check if the email is  already exist */

        if(!userService.isUsernameTaken(clientEntity.getClient_email())){
            clientEntity.getClient_user().setUsername(clientEntity.getClient_email());
            ClientEntity saved= client.save(clientEntity);
            return modelMapper.map(saved, ClientResponse.class);
        }else{
            throw  new EntityNotFoundException("Already Exist Client");
        }



    }
    public ClientResponse update(ClientRequest clientRequest, Long id){
        Optional<ClientEntity> clientEntityOptional=client.findById(id);
        if(clientEntityOptional.isPresent()){
            ClientEntity clientEntity= modelMapper.map(clientRequest,ClientEntity.class);
            clientEntity.setClient_id(id);
            ClientEntity updated=client.save(clientEntity);
            return modelMapper.map(updated,ClientResponse.class);
        }else{
            throw new EntityNotFoundException("Client Not Found");
        }
    }
    public ClientResponse get(Long id){
        ClientEntity clientEntity= client.findById(id).orElseThrow(()->new EntityNotFoundException("Client Not Found"));
        return modelMapper.map(clientEntity,ClientResponse.class);
    }

    public void delete(Long id){
        client.deleteById(id);
    }

    public List<ClientResponse> getAll(){
        return client.findAll().stream()
                .map(el->modelMapper.map(el,ClientResponse.class))
                .collect(Collectors.toList());

    }
}
