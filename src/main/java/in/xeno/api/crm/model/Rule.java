package in.xeno.api.crm.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table
@Data
@ToString
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String operator; //case: self reference

    @OneToOne
    private Rule leftRule;
    @OneToOne
    private Rule rightRule;
    private String query; //case: direct rule
}
