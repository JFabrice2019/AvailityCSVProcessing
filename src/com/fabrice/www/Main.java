package com.fabrice.www;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\PC\\Desktop\\";
        String extension = ".txt";

        File file = new File(path+"availity.csv");
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        String line;
        List<Enrollee> list = new ArrayList<>();

        while((line = br.readLine()) != null) {
            String[] values = line.split(",");
            Enrollee enrollee = new Enrollee(values[0], values[1], values[2], Integer.parseInt(values[3]), values[4]);
            list.add(enrollee);
        }


        UIDComparator comparator = new UIDComparator();
        //list.sort(comparator);

        Set<Enrollee> set = new TreeSet<>();

        for(int i = 0; i < list.size(); i++) {
            Enrollee highestVersion = list.get(i);
            for(int j = 1; j < list.size();  j++) {
                if(comparator.compare(highestVersion, list.get(j)) < 0) {
                        highestVersion = list.get(j);
                }
            }
            set.add(highestVersion);
        }

        for(Enrollee enrollee : set) {
            String fileName = path+enrollee.insuranceCompany+extension;
            FileWriter writer = new FileWriter(fileName, true);
            file = new File(fileName);
            if(!file.createNewFile()) {
                writer.append(enrollee.uid).append(",").append(enrollee.firstName).append(",").append(enrollee.lastName).append(",").append(String.valueOf(enrollee.version)).append(",").append(enrollee.insuranceCompany).append("\n");
            }
            writer.close();
        }
    }
}
