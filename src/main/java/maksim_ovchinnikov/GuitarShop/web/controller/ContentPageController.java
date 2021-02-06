package maksim_ovchinnikov.GuitarShop.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maksim_ovchinnikov.GuitarShop.business.service.GuitarService;
import maksim_ovchinnikov.GuitarShop.business.service.UserAccountService;
import maksim_ovchinnikov.GuitarShop.dto.GuitarResponse;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guitar")
@Slf4j
public class ContentPageController {

    private final GuitarService guitarService;

    private final UserAccountService userAccountService;

    @GetMapping("/{id}")
    public GuitarResponse getGuitar(@PathVariable Long id){
        return guitarService.getGuitarById(id);
    }

    @PutMapping("/{id}/buy_request")
    public Integer userBuyGuitars(Principal principal, @PathVariable Long id){
        return userAccountService.userBuyGuitars(principal, id);
    }
}
