package org.eyupcompany.invoicesmanage.dto.requests;

import lombok.*;
import org.eyupcompany.invoicesmanage.models.UserEntity;

import java.util.Date;
@Data
public class ClientRequest {
    private String client_firstname;
    private String client_surname1;
    private String client_surname2;
    private Date client_birthday;
    private String client_phone;
    private String client_email;
    private UserEntity client_user;


}
