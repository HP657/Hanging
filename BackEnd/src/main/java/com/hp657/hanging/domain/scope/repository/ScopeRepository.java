package com.hp657.hanging.domain.scope.repository;

import com.hp657.hanging.domain.scope.entity.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScopeRepository extends JpaRepository<Scope, Long> {
}
