package com.example.Citronix.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Services<EntityReq, EntityRes> {
    Optional<EntityRes> get(UUID id);
    List<EntityRes> getAll();
    EntityRes save(EntityReq reqEntity);
    EntityRes update(EntityReq reqEntity, UUID oldId);
    boolean delete(UUID oldId);
}
