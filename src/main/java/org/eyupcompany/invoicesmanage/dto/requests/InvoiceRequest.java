package org.eyupcompany.invoicesmanage.dto.requests;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InvoiceRequest {
        private String ref;
        private Date date;
        private List<ProductRequest> products;
}
