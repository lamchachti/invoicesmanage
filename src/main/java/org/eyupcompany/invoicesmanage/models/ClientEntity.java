package org.eyupcompany.invoicesmanage.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
public class ClientEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long client_id;
    @Column(nullable = false)
    private String client_firstname;
    @Column(nullable = false)
    private String client_surname1;
    //@Column(nullable = true)
    private String client_surname2;
    //@Column(nullable = true)
    private String client_birthday;
    //@Column(nullable = false)
    private String client_phone;
    //@Column(nullable = false)
    private String client_email;

    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="client_user")
    private UserEntity client_user;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="client")
    private List<InvoiceEntity> invoices;
}
