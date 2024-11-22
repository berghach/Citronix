package com.example.Citronix.Validators;

import com.example.Citronix.entities.Field;
import com.example.Citronix.entities.Harvest;
import com.example.Citronix.entities.HarvestDetail;
import com.example.Citronix.entities.Tree;

import java.time.LocalDate;

public class Validator {

    public static void isDensityValid(double fieldArea, int numberOfTrees) throws Exception {
        double density = numberOfTrees / fieldArea;

        if (density > 0.01) throw new Exception("The maximum number of trees on a field is 10 tree per a 1000 m²");
    }

    public static void isPlantationDateValid(Field field, LocalDate plantationDate) throws Exception {
        LocalDate start = LocalDate.of(LocalDate.now().getYear(), 3, 1);
        LocalDate end = LocalDate.of(LocalDate.now().getYear(), 5, 31);

        if (plantationDate.isBefore(field.getFarm().getCreationDate()))
            throw new Exception("The plantation date should be after the farm creation date:" + field.getFarm().getCreationDate());

        if (!(plantationDate.isEqual(start) || plantationDate.isAfter(start))
                ||
                !(plantationDate.isEqual(end) || plantationDate.isBefore(end)))
            throw new Exception("The plantation date should be between:" +
                    start + " and " + end
                    );
    }

    public static void isOldToBeHarvested(Tree tree, Harvest harvest) throws Exception {
        if (tree.getAge() >= 20)
            throw new Exception("This tree is too old to be harvested.");
    }

    public static void isAlreadyHarvested(Tree tree, HarvestDetail harvestDetail) throws Exception {
        if (tree.getHarvestDetails().contains(harvestDetail))
            throw new Exception("This tree can not be harvested twice in the same season");
    }


}
