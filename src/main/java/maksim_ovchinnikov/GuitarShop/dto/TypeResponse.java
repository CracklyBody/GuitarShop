package maksim_ovchinnikov.GuitarShop.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeResponse {
    Long id;
    String name;
}
