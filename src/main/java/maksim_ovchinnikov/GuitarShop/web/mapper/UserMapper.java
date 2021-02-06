package maksim_ovchinnikov.GuitarShop.web.mapper;

import maksim_ovchinnikov.GuitarShop.business.entity.UserAccount;
import maksim_ovchinnikov.GuitarShop.dto.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserAccount, UserResponse> {
    UserResponse toDTO(UserAccount userAccount);
}
