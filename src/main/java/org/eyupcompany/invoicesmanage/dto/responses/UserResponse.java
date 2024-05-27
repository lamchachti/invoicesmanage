package org.eyupcompany.invoicesmanage.dto.responses;

import lombok.Data;

@Data
public class UserResponse {
    private Long user_id;
    private String username;
    private String user_phone;
}
