package maksim_ovchinnikov.GuitarShop.business.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import maksim_ovchinnikov.GuitarShop.business.dao.GuitarRepository;
import maksim_ovchinnikov.GuitarShop.business.dao.UserRepository;
import maksim_ovchinnikov.GuitarShop.business.entity.Guitar;
import maksim_ovchinnikov.GuitarShop.business.entity.UserAccount;
import maksim_ovchinnikov.GuitarShop.business.service.UserAccountService;
import maksim_ovchinnikov.GuitarShop.dto.AuthorizationToken;
import maksim_ovchinnikov.GuitarShop.dto.GuitarAmountRequest;
import maksim_ovchinnikov.GuitarShop.dto.RequestAuth;
import maksim_ovchinnikov.GuitarShop.dto.UserResponse;
import maksim_ovchinnikov.GuitarShop.exception.GuitarsLowAmountException;
import maksim_ovchinnikov.GuitarShop.exception.UserLowCashException;
import maksim_ovchinnikov.GuitarShop.helper.ObjectToUrlEncodedConverter;
import maksim_ovchinnikov.GuitarShop.web.mapper.UserMapper;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserRepository userRepository;

    private final GuitarRepository guitarRepository;

    private final UserMapper userMapper;

    @Override
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Integer userBuyGuitars(Principal principal, Long id) {
        UserAccount user = userRepository.getUserAccountByUsername(principal.getName());
        try {
            return userTryBuyGuitars(user, id);
        }
        catch (UserLowCashException | GuitarsLowAmountException e){
            System.out.println(e.toString());
            return -1;
        }
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        return userMapper.toDTO(userRepository.getUserAccountByUsername(username));
    }

    private Integer userTryBuyGuitars(UserAccount user, Long id) throws GuitarsLowAmountException, UserLowCashException {
        Integer totalPrice = 0;
        Guitar guitarFromDB = guitarRepository.getGuitarById(id);
        if (guitarFromDB.getAmount() > 0) {
            totalPrice += guitarFromDB.getPrice();
            guitarFromDB.setAmount(guitarFromDB.getAmount() - 1);
        } else throw new GuitarsLowAmountException("Guitar amount low");
        if (totalPrice <= user.getCash()) {
            user.setCash(user.getCash() - totalPrice);
            userRepository.save(user);
            guitarRepository.save(guitarFromDB);
            return user.getCash();
        }
        else throw new UserLowCashException("User cash low");
    }

    @Override
    public AuthorizationToken authenticationUser(RequestAuth requestAuth, String authorization) {
        String uri = "http://localhost:8082/oauth/token";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new ObjectToUrlEncodedConverter(new ObjectMapper()));
        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(createBody(requestAuth), createHeaders(authorization));
        return restTemplate.postForObject(uri, request , AuthorizationToken.class);
    }

    private HttpHeaders createHeaders(String authorization){
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(authorization.split(" ")[1]);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }

    private Map<String, Object> createBody(RequestAuth requestAuth){
        Map<String, Object> bodyRequest = new HashMap<>();
        bodyRequest.put("grant_type", requestAuth.getGrant_type());
        bodyRequest.put("username", requestAuth.getUsername());
        bodyRequest.put("password", requestAuth.getPassword());
        return bodyRequest;
    }
}
