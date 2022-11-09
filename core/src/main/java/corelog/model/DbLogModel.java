package corelog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "db_log")
@AllArgsConstructor
@NoArgsConstructor
public class DbLogModel {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;
    @Column(name = "system_type_id")
    private Long systemTypeId;
    @Column(name = "method_params")
    private String methodParams;

}
