package org.eyupcompany.invoicesmanage.dto.responses;

import lombok.Data;

@Data
public class ClientResponse {
    private Long client_id;
    private String client_firstname;
    private String client_surname1;
    private String client_surname2;
    private String client_birthday;
    private String client_phone;
    private String client_email;
}
