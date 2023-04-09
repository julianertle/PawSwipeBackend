package org.example.demo;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Profile")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Username")
    private String username;

    @Column(name = "ProfilePicture")
    private byte[] profilePicture;

    @Column(name = "Email")
    private String email;

    @Column(name = "IsComplete")
    private Boolean isComplete;

    @Column(name = "Birthday")
    private Date birthday;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Country")
    private String country;

    @Column(name = "City")
    private String city;

    @Column(name = "StreetNumber")
    private int streetNumber;

    @Column(name = "Homepage")
    private String homepage;

    @Column(name = "PostalCode")
    private int postalCode;

    @Column(name = "Discriminator", insertable = false, updatable = false)
    private String discriminator;

    // Constructors
    public Profile() {}

    public Profile(String username, byte[] profilePicture, String email, Boolean isComplete, Date birthday,
                   String phoneNumber, String country, String city, int streetNumber, String homepage,
                   int postalCode) {
        this.username = username;
        this.profilePicture = profilePicture;
        this.email = email;
        this.isComplete = isComplete;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.streetNumber = streetNumber;
        this.homepage = homepage;
        this.postalCode = postalCode;
    }



    // Getters and Setters (omitted)


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }
}

