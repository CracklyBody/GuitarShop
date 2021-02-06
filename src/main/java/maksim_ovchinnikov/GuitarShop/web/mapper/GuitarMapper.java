package maksim_ovchinnikov.GuitarShop.web.mapper;

import maksim_ovchinnikov.GuitarShop.business.entity.Guitar;
import maksim_ovchinnikov.GuitarShop.dto.GuitarResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuitarMapper extends GenericMapper<Guitar, GuitarResponse> {
    GuitarResponse toDTO(Guitar guitar);
}
