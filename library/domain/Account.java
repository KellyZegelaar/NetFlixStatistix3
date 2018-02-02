package library.domain;

import java.util.ArrayList;

public class Account {
    private String name;
    private ArrayList<Profile> profiles;
    private Address address;
    private String subscriberNumber;

    public Account(String name, ArrayList<Profile> profiles, Address address, String subscriberNumber) {
        this.name = name;
        this.profiles = profiles;
        this.address = address;
        this.subscriberNumber = subscriberNumber;
    }
}
