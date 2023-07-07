package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service, String> {

}
