package org.eyupcompany.invoicesmanage.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Table(name = "products")
@Data
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;
    @Column(nullable = false)
    private String product_label;
    @Column(nullable = false)
    private Double product_price;
    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer product_available_quantity;
}
