package maksim_ovchinnikov.GuitarShop.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maksim_ovchinnikov.GuitarShop.business.service.UserAccountService;
import maksim_ovchinnikov.GuitarShop.dto.AuthorizationToken;
import maksim_ovchinnikov.GuitarShop.dto.RequestAuth;
import maksim_ovchinnikov.GuitarShop.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthorizationController {

    private final UserAccountService userAccountService;

    @PostMapping( "/request")
    ResponseEntity<AuthorizationToken> authorizationRequest(RequestAuth requestAuth,
                                                            @RequestHeader String authorization){
        log.info("{}, {}", requestAuth, authorization);
        return ResponseEntity.ok().body(userAccountService.authenticationUser(requestAuth, authorization));
    }

    @GetMapping("/current")
    UserResponse getUserByUsername(@RequestParam String username){
        return userAccountService.getUserByUsername(username);
    }
}
