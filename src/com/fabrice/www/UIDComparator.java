package com.fabrice.www;

import java.util.Comparator;

class UIDComparator implements Comparator<Enrollee> {

    @Override
    public int compare(Enrollee e1, Enrollee e2) {
        if(e1.uid.equals(e2.uid) && e1.insuranceCompany.equals(e2.insuranceCompany)){
            if(e1.version < e2.version) {
                return -1;
            }
            else if(e1.version > e2.version) {
                return 1;
            }
        }
        return 0;
    }
}