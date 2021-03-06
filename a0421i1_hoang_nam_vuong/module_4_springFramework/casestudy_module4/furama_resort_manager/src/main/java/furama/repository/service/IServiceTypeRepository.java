package furama.repository.service;

import furama.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}
