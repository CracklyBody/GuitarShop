package maksim_ovchinnikov.GuitarShop.business.service;

import maksim_ovchinnikov.GuitarShop.dto.AuthorizationToken;
import maksim_ovchinnikov.GuitarShop.dto.RequestAuth;
import maksim_ovchinnikov.GuitarShop.dto.UserResponse;

import java.security.Principal;

public interface UserAccountService {
    Integer userBuyGuitars(Principal principal, Long id);
    UserResponse getUserByUsername(String username);
    AuthorizationToken authenticationUser(RequestAuth requestAuth, String authorization);
}
