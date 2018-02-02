package library.domain;

public class Profile {
    private String profileName;
    private String dateOfBirth;
    private String subscriberNumber;

    public Profile(String profileName, String dateOfBirth, String subscriberNumber) {
        this.profileName = profileName;
        this.dateOfBirth = dateOfBirth;
        this.subscriberNumber = subscriberNumber;
    }
}
