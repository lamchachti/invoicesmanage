package org.eyupcompany.invoicesmanage.dao;

import org.aspectj.apache.bcel.generic.LOOKUPSWITCH;
import org.eyupcompany.invoicesmanage.models.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Invoice extends JpaRepository<InvoiceEntity, Long> {
}
