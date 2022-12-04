package org.soulcodeacademy.empresa.reporsitories;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpregadoRepository extends JpaRepository<Empregado, Integer> {
}
