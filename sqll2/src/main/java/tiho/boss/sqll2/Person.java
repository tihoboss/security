package tiho.boss.sqll2;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Setter
@Getter
@Embeddable
public class Person implements Serializable {
    private String name;
    private String surname;
    private Integer age;
}