package maksim_ovchinnikov.GuitarShop.business.dao;

import maksim_ovchinnikov.GuitarShop.business.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    UserAccount getUserAccountByUsername(String username);
}
