package library.domain;

public class Address {
    private String street;
    private String city;
    private String postalCode;
    private String houseNumber;

    public Address(String street, String postalCode, String houseNumber, String city) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
    }
}
