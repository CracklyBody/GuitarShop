package maksim_ovchinnikov.GuitarShop.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GuitarMainPageResponse {
    Long id;
    String name;
    TypeResponse type;
    Integer price;
}
