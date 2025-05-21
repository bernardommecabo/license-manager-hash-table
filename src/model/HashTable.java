package model;

import java.util.ArrayList;

public class HashTable {
    private ArrayList<License>[] licences;
    private int m;
    private int settingValue;

    @SuppressWarnings("unchecked")
    public HashTable(int m, int settingValue) {
        this.m = m;
        this.settingValue = settingValue;
        this.licences = new ArrayList[m];

        for (int i = 0; i < m; i++) {
            licences[i] = new ArrayList<>();
        }
    }

    public int hash(int id) {
        return Math.abs((id * settingValue) % m);
    }

    public ArrayList<License>[] getLicenses() {
        return licences;
    }
    
    public int getM() {
        return m;
    }

}
