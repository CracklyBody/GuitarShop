package maksim_ovchinnikov.GuitarShop.business.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "type")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @OneToMany(mappedBy = "type")
    Set<Guitar> guitars;
}
