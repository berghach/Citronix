package com.example.Citronix.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Services<EntityReq, EntityRes> {
    Optional<EntityRes> get(UUID id);
    List<EntityRes> getAll();
    boolean save(EntityReq entity);
    boolean update(EntityReq entity);
    boolean delete(EntityReq entity);
}
