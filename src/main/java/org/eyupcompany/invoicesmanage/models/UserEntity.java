package org.eyupcompany.invoicesmanage.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Table(name = "users")
@Data
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String user_phone;
    @OneToOne(mappedBy = "client_user",cascade = CascadeType.ALL)
    private ClientEntity user_client;
}
