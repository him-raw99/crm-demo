package in.xeno.api.crm.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


//when add login
@Entity
@Table
@Data
@ToString
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
}
