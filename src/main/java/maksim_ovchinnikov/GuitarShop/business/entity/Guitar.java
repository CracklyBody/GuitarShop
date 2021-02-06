package maksim_ovchinnikov.GuitarShop.business.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity(name = "guitar")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Guitar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @NotNull
    Integer amount;

    @NotNull
    Integer price;

    @NotNull
    String description;

    @NotNull
    Integer weight;

    @NotNull
    Integer length;

    @NotNull
    Integer height;

    @NotNull
    String url;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    Type type;
}
