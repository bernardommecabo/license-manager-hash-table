package util;

import java.util.ArrayList;
import java.util.List;
import model.License;

public class LicenseGenerator {
    public static List<License> generateLicences (int n) {
        List<License> licences = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = i + 1;
            boolean isActive = Math.random() < 0.5;
            licences.add(new License(id, isActive));
        }
        return licences;
    }
}
