package org.eyupcompany.invoicesmanage.services;
import org.eyupcompany.invoicesmanage.dao.User;
import org.eyupcompany.invoicesmanage.dao.UserExtended;
import org.eyupcompany.invoicesmanage.dto.requests.UserRequest;
import org.eyupcompany.invoicesmanage.dto.responses.UserResponse;
import org.eyupcompany.invoicesmanage.exceptions.EntityNotFoundException;
import org.eyupcompany.invoicesmanage.models.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {
    @Autowired
    private User user;
    private UserExtended userExtended;
    private ModelMapper modelMapper;

    public UserService(ModelMapper modelMapper, User user,UserExtended userExtended){
        this.user=user;
        this.modelMapper=modelMapper;
        this.userExtended=userExtended;
    }

    public boolean isUsernameTaken(String username){
        return user.existsByUsername(username);
    }

    public UserEntity findByUsername(String username){
            return user.findByUsername(username);
    }

    public UserResponse login(UserRequest userRequest){
       UserEntity userEntity=userExtended.login(userRequest);
        System.out.println(userEntity);
       if(userEntity!=null){
           return modelMapper.map(userEntity,UserResponse.class);
       }else {
           throw new EntityNotFoundException("Credencials are not Correct");
       }
    }


    
}
