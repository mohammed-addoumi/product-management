package org.example.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.product.command.ProductCommand;

import javax.persistence.*;

@Entity
@Table(name = "product_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq_generator")
    @SequenceGenerator(sequenceName = "product_seq",name = "product_seq_generator",allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;

    public static Product from(ProductCommand productCommand) {
        Product product = new Product();
        product.name = productCommand.getName();
        return product;
    }
}
