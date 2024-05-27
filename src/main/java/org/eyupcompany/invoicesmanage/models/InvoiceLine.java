package org.eyupcompany.invoicesmanage.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name="invoice_line")
@Data
public class InvoiceLine implements Serializable {
    @EmbeddedId
    InvoiceProductKey id;
    @ManyToOne
    @MapsId("invoice_id")
    @JoinColumn(name="invoice_id")
    private  InvoiceEntity invoice;
    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name="product_id")
    private ProductEntity produit;
    private Double quantity;

}
