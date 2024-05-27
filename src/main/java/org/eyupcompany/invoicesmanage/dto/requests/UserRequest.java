package org.eyupcompany.invoicesmanage.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.eyupcompany.invoicesmanage.models.UserRole;
@Data
public class UserRequest {
    @NotBlank
    private String username;
    private String password;
}
