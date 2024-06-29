package in.xeno.api.crm.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table
@Data
@ToString
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToOne
    private Merchant merchant;

    @OneToOne private Rule rule;
}
