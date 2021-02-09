package week15.d02;

import java.util.Objects;

public class Address {
    private String postalCode;
    private String street;
    private String number;

    public Address(String postalCode, String street, String number) {
        this.postalCode = postalCode;
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return postalCode + ' ' + street + ' ' +number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(postalCode, address.postalCode) && Objects.equals(street, address.street) && Objects.equals(number, address.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode, street, number);
    }
}
