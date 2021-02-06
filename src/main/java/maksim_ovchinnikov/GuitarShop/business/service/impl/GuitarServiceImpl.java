package maksim_ovchinnikov.GuitarShop.business.service.impl;

import lombok.RequiredArgsConstructor;
import maksim_ovchinnikov.GuitarShop.business.dao.GuitarRepository;
import maksim_ovchinnikov.GuitarShop.business.service.GuitarService;
import maksim_ovchinnikov.GuitarShop.dto.GuitarMainPageResponse;
import maksim_ovchinnikov.GuitarShop.dto.GuitarResponse;
import maksim_ovchinnikov.GuitarShop.web.mapper.GuitarMainPageMapper;
import maksim_ovchinnikov.GuitarShop.web.mapper.GuitarMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuitarServiceImpl implements GuitarService {

    private final GuitarRepository guitarRepository;

    private final GuitarMapper guitarMapper;

    private final GuitarMainPageMapper guitarMainPageMapper;

    @Override
    public List<GuitarMainPageResponse> getGuitars() {
        return guitarMainPageMapper.toDTOs(guitarRepository.getAllBy());
    }

    @Override
    public GuitarResponse getGuitarById(Long id) {
        return guitarMapper.toDTO(guitarRepository.getGuitarById(id));
    }
}
