package controller;

import service.LicenseService;

import java.util.ArrayList;

import model.License;
import util.LicenseGenerator;

public class LicenseController {
    private LicenseService licenceService;

    public LicenseController(String matricula) {
        this.licenceService = new LicenseService(matricula);
    }

    public void insertLicence(License licence) {
        licenceService.insertLicence(licence);
    }

    public License getLicence(int id) {
        return licenceService.getLicence(id);
    }

    public boolean removeLicence(int id) {
        return licenceService.removeLicence(id);
    }

    public void generateLicences(int n) {
        for (License licence : LicenseGenerator.generateLicences(n)) {
            insertLicence(licence);
        }
    }

    public void listLicences() {
    ArrayList<License> licenses = licenceService.listLicences();
        for (License license : licenses) {
            System.out.println("Licenca - " + license.getId() + " isActive - " + license.isActive());
        }
    }
}
