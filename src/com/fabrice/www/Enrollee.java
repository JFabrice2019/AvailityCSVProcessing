package com.fabrice.www;

class Enrollee implements Comparable<Enrollee> {
    String uid;
    String firstName;
    String lastName;
    int version;
    String insuranceCompany;

    public Enrollee(String uid, String firstName, String lastName, int version, String insuranceCompany) {
        super();
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.version = version;
        this.insuranceCompany = insuranceCompany;
    }

    public int compareTo(Enrollee e) {
        int initialCheck = lastName.compareTo(e.lastName);
        if(initialCheck != 0) {
            return initialCheck;
        }
        else {
            return firstName.compareTo(e.firstName);
        }
    }
}