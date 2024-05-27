package org.eyupcompany.invoicesmanage.dao;

import org.eyupcompany.invoicesmanage.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Product extends JpaRepository<ProductEntity,Long> {
}
