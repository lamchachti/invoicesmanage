package org.eyupcompany.invoicesmanage.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "invoices")
@Data
public class InvoiceEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long invoice_id;
    @Column(nullable = false)
    private Date invoice_date;
    @Column(nullable = false)
    private String invoice_ref;
    @Column(columnDefinition = "VARCHAR(30) DEFAULT 'unpayed'")
    private String invoice_status;
}
