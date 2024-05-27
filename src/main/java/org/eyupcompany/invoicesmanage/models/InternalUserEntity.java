package org.eyupcompany.invoicesmanage.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name = "interusers")
@Data
public class InternalUserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long interuser_id;
    @Column(nullable = false,unique = true)
    private String interusername;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String interuser_phone;
    @Column(name = "role",nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @OneToOne
    @JoinColumn(name = "staff")
    private StaffEntity staff;
}
