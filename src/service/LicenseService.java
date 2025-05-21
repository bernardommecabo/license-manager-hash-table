package service;

import model.HashTable;
import model.License;

import java.util.ArrayList;

public class LicenseService {
    private HashTable hashTable;

    public LicenseService(String matricula) {
        int m = calcTableSize(matricula);
        int fatorAjuste = calculaFatorAjuste(matricula);
        this.hashTable = new HashTable(m, fatorAjuste); 
    }

    public void insertLicence(License licence) {
        int index = hashTable.hash(licence.getId());
        ArrayList<License> bucket = hashTable.getLicenses()[index];

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getId() == licence.getId()) {
                bucket.set(i, licence); 
                return;
            }
        }

        bucket.add(licence);  
    }

    public License getLicence(int id) {
        int index = hashTable.hash(id);
        for (License licence : hashTable.getLicenses()[index]) {
            if (licence.getId() == id) {
                return licence;
            }
        }
        return null;
    }

    public boolean removeLicence(int id) {
        int index = hashTable.hash(id);
        ArrayList<License> bucket = hashTable.getLicenses()[index];

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getId() == id) {
                bucket.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<License> listLicences() {
        ArrayList<License> all = new ArrayList<>();
        for (ArrayList<License> bucket : hashTable.getLicenses()) {
            all.addAll(bucket);
        }
        return all;
    }

    public int getTamanhoTabela() {
        return hashTable.getM();
    }

    public ArrayList<License>[] getBuckets() {
        return hashTable.getLicenses();
    }

    private int calcTableSize(String matricula) {
        int sum = 0;
        for (char c : matricula.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return (sum % 100) + 50;
    }

    private int calculaFatorAjuste(String matricula) {
        int penultimate = Character.getNumericValue(matricula.charAt(matricula.length() - 2));
        return penultimate + 1;
    }
}
