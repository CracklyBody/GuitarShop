package maksim_ovchinnikov.GuitarShop.business.service;

import maksim_ovchinnikov.GuitarShop.dto.GuitarMainPageResponse;
import maksim_ovchinnikov.GuitarShop.dto.GuitarResponse;

import java.util.List;

public interface GuitarService {
    List<GuitarMainPageResponse> getGuitars();
    GuitarResponse getGuitarById(Long id);
}
