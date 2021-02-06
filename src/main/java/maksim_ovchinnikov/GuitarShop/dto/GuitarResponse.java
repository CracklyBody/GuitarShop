package maksim_ovchinnikov.GuitarShop.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GuitarResponse {
    Long id;
    String name;
    Integer amount;
    Integer price;
    String description;
    Integer weight;
    Integer length;
    Integer height;
    String url;
    TypeResponse type;
}
