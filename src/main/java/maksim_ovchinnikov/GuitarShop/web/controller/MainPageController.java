package maksim_ovchinnikov.GuitarShop.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maksim_ovchinnikov.GuitarShop.business.service.GuitarService;
import maksim_ovchinnikov.GuitarShop.business.service.UserAccountService;
import maksim_ovchinnikov.GuitarShop.dto.GuitarMainPageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainPageController {

    public final GuitarService guitarService;

    public final UserAccountService userAccountService;

    @GetMapping
    public List<GuitarMainPageResponse> getGuitars(){
        return guitarService.getGuitars();
    }
}
