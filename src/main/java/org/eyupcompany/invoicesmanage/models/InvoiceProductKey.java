package org.eyupcompany.invoicesmanage.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class InvoiceProductKey implements Serializable {
    private Long invoice_id;
    private Long product_id;
}
