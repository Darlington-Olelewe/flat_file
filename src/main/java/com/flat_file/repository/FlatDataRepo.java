package com.flat_file.repository;

import com.flat_file.model.FlatData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatDataRepo extends JpaRepository<FlatData,Long> {
}
