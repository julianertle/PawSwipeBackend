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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProfile_picture(byte[] profilePicture) {
        this.profile_picture = profilePicture;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreation_date(Date creationDate) {
        this.creation_date = creationDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPhone_number(String phoneNumber) {
        this.phone_number = phoneNumber;
    }

    public void setOpening_hours(String openingHours) {
        this.opening_hours = openingHours;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet_number(int streetNumber) {
        this.street_number = streetNumber;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setPostal_code(int postalCode) {
        this.postal_code = postalCode;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    @Column(name = "is_admin", columnDefinition = "TINYINT default 0")  // @todo security risk cause with a create request you could define this true with "is_admin":1
    private int is_admin;

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