package com.tiendd.bookservice.responsitory;

import com.tiendd.bookservice.api.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRespository extends JpaRepository<Record, Long> {
}
