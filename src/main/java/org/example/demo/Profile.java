package org.example.demo;
import javax.persistence.*;
import java.sql.Date;

/**
 * The {@link Profile} class represents a profile entity.
 * It is mapped to the "profile" table in the database.
 * This class contains properties representing various attributes of a profile, such as username, first name,
 * last name, email, etc.
 * The class is annotated with JPA annotations to define the mapping between the class and the database table.
 * It is used to store and retrieve profile information from the database.
 *
 * @author Julian Ertle
 */
@Entity
@Table(name = "profile")
public class Profile {   //@todo javadoc

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

    @Column(name = "is_admin", columnDefinition = "TINYINT default 0")  // @todo security risk, with a create request you could define this true with "is_admin":1
    private int is_admin;

    @Column(name = "profile_picture")
    private String profile_picture;

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
    private String street_number;

    @Column(name = "homepage")
    private String homepage;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lon")
    private double lon;

    @Column(name = "discriminator") //, insertable = false, updatable = false
    private String discriminator;
    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
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

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
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

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {
        this.opening_hours = opening_hours;
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

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }


    // Constructors
    public Profile() {
    }

    public Profile(String username, String profile_picture, String description, String password, Date creation_date,
                   String email, Date birthday, String phone_number, String opening_hours,
                   String street, String country, String city, String street_number, String homepage, String postal_code,
                   String firstname, String lastname, double lat, double lon) {
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
        this.lat = lat;
        this.lon = lon;
    }
}