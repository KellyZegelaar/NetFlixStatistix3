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

    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileName='" + profileName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", subscriberNumber='" + subscriberNumber + '\'' +
                '}';
    }
}
