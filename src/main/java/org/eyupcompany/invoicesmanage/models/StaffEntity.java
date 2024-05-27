package org.eyupcompany.invoicesmanage.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "staffs")
@Data
public class StaffEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long staff_id;
    @Column(nullable = false)
    private String staff_company_serial_number;
    @Column(nullable = false)
    private String staff_firstname;
    @Column(nullable = false)
    private String staff_surname1;
    private String staff_surname2;
    @Column(nullable = false)
    private Date staff_birthday;
    @Column(nullable = false)
    private String staff_phone;
    @Column(nullable = false)
    private String staff_email;
    @OneToOne(mappedBy = "staff",cascade = CascadeType.ALL)
    @JoinColumn(name="internuser")
    private InternalUserEntity user;

}
