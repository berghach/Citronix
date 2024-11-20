package com.example.Citronix.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class HarvestDetailId implements Serializable {
    private UUID harvestId;
    private UUID treeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HarvestDetailId that = (HarvestDetailId) o;
        return Objects.equals(harvestId, that.harvestId) && Objects.equals(treeId, that.treeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(harvestId, treeId);
    }
}
