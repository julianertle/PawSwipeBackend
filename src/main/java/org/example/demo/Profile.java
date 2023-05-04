package org.example.demo;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "profile")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator")
public class Profile {

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profileId) {
        this.profile_id = profileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(byte[] profilePicture) {
        this.profile_picture = profilePicture;
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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creationDate) {
        this.creation_date = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phoneNumber) {
        this.phone_number = phoneNumber;
    }

    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String openingHours) {
        this.opening_hours = openingHours;
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

    public int getStreet_number() {
        return street_number;
    }

    public void setStreet_number(int streetNumber) {
        this.street_number = streetNumber;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postalCode) {
        this.postal_code = postalCode;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id",unique = true)
    private int profile_id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "profile_picture")
    private byte[] profile_picture;

    @Column(name = "description")
    private String description;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "creation_date")
    private Date creation_date;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone_number", unique = true)
    private String phone_number;

    @Column(name = "opening_hours")
    private String opening_hours;

    @Column(name = "street")
    private String street;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street_number")
    private int street_number;

    @Column(name = "homepage")
    private String homepage;

    @Column(name = "postal_code")
    private int postal_code;

    @Column(name = "discriminator", insertable = false, updatable = false)
    private String discriminator;

    // Constructors
    public Profile() {
    }

    public Profile(String username, byte[] profile_picture, String description, String password, Date creation_date,
                   String email, Date birthday, String phone_number, String opening_hours,
                   String street, String country, String city, int street_number, String homepage, int postal_code, String firstname, String lastname) {
        this.username = username;
        this.profile_picture = profile_picture;
        this.description = description;
        this.password = password;
        this.creation_date = creation_date;
        this.email = email;
        this.birthday = birthday;
        this.phone_number = phone_number;
        this.opening_hours = opening_hours;
        this.street = street;
        this.country = country;
        this.city = city;
        this.street_number = street_number;
        this.homepage = homepage;
        this.postal_code = postal_code;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}