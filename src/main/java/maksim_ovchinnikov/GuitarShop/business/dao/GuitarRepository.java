package maksim_ovchinnikov.GuitarShop.business.dao;

import maksim_ovchinnikov.GuitarShop.business.entity.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuitarRepository extends JpaRepository<Guitar, Long> {
    List<Guitar> getAllBy();
    Guitar getGuitarById(Long id);
}
