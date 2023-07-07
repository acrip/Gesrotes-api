package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShiftRepository extends JpaRepository<Shift, String> {

}
