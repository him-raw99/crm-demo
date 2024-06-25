package in.xeno.api.crm.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table
@Data
@ToString
public class CommunicationLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String status;

    @OneToOne
    private Campaign campaign;
}
