package product.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private int stock;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<VehicleDetail> productDetails;

    @ManyToMany
    //@JoinTable(name="product_customerSSSS",joinColumns = @JoinColumn(name="product_id"),inverseJoinColumns = @JoinColumn (name="customer_id"))
    private List<Customer> customers;












}
