package tiho.boss.sqll2;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Data
public class Persons {
    @EmbeddedId
    private Person id;

    @Column(name = "phone_number",nullable = false, length = 255)
    private String phoneNumber;

    @Column(name = "city_of_living", nullable = false, length = 255)
    private String cityOfLiving;
}