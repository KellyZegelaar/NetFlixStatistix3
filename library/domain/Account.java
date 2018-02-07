package library.domain;

import java.util.ArrayList;

public class Account {
    private String name;
    private ArrayList<Profile> profiles;
    private Address address;
    private String subscriberNumber;

    public Account(String name, Address address, String subscriberNumber) {
        this.name = name;
        this.address = address;
        this.subscriberNumber = subscriberNumber;

        profiles = new ArrayList<>();
    }

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

}
