package maksim_ovchinnikov.GuitarShop.web.mapper;

import maksim_ovchinnikov.GuitarShop.business.entity.Guitar;
import maksim_ovchinnikov.GuitarShop.dto.GuitarMainPageResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GuitarMainPageMapper extends GenericMapper<Guitar, GuitarMainPageResponse> {
    List<GuitarMainPageResponse> toDTOs(List<Guitar> guitars);
}
