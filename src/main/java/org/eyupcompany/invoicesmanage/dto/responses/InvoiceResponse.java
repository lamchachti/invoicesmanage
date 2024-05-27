package org.eyupcompany.invoicesmanage.dto.responses;

import java.util.Date;
import java.util.List;

public class InvoiceResponse {
    private Long id;
    private String ref;
    private Date date;
    private List<ProductResponse> products;
}
