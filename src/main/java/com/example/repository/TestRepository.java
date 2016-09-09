package com.example.repository;

import com.example.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author ymolodkov on 09.09.16.
 */

public interface TestRepository extends JpaRepository<Test, UUID> {
}
