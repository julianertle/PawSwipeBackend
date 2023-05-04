package org.example.demo;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "profile")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private int profileId;

    @Column(name = "username")
    private String username;

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getComplete() {
        return isComplete;
    }

    public void setComplete(int complete) {
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

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @Column(name = "description")
    private String description;

    @Column(name = "password")
    private String password;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "email")
    private String email;

    @Column(name = "is_complete")
    private int isComplete;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "opening_hours")
    private String openingHours;

    @Column(name = "street")
    private String street;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street_number")
    private int streetNumber;

    @Column(name = "homepage")
    private String homepage;

    @Column(name = "postal_code")
    private int postalCode;

    @Column(name = "discriminator", insertable = false, updatable = false)
    private String discriminator;

    // Constructors
    public Profile() {
    }

    public Profile(String username, byte[] profilePicture, String description, String password, Date creationDate,
                   String email, int isComplete, Date birthday, String phoneNumber, String openingHours,
                   String street, String country, String city, int streetNumber, String homepage, int postalCode, String firstname, String lastname) {
        this.username = username;
        this.profilePicture = profilePicture;
        this.description = description;
        this.password = password;
        this.creationDate = creationDate;
        this.email = email;
        this.isComplete = isComplete;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.openingHours = openingHours;
        this.street = street;
        this.country = country;
        this.city = city;
        this.streetNumber = streetNumber;
        this.homepage = homepage;
        this.postalCode = postalCode;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}