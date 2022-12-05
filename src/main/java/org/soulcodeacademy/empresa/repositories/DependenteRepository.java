package org.soulcodeacademy.empresa.repositories;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependenteRepository extends JpaRepository<Dependente, Integer> {
}
