package org.example.demo;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "profile")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator")
public class Profile {

    public int getProfileId() {
        return profileId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public void setProfilePicture(byte[] profilepicture) {
        this.profilePicture = profilepicture;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreationDate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostalCode(String postalcode) {
        this.postalcode = postalcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setOpeningHours(String openinghours) {
        this.openinghours = openinghours;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profileid")
    private int profileId;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "profilepicture")
    private byte[] profilePicture;

    @Column(name = "description")
    private String description;

    @Column(name = "password")
    private String password;

    @Column(name = "creationdate")
    private Date creationdate;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "country")
    private String country;

    @Column(name = "postalcode")
    private String postalcode;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "streetnumber")
    private String streetnumber;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "openinghours")
    private String openinghours;

    @Column(name = "homepage")
    private String homepage;

    @Column(name = "discriminator")
    private String discriminator;

    @Column(name = "email")
    private String email;

    // Constructors
    public Profile() {
    }

    public Profile(int profileId, String username, String firstname, String lastname, byte[] profilePicture, String description, String password, Date creationdate, String phonenumber, String country, String postalcode, String city, String street, String streetnumber, Date birthday, String openinghours, String homepage, String discriminator, String email) {
        this.profileId = profileId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profilePicture = profilePicture;
        this.description = description;
        this.password = password;
        this.creationdate = creationdate;
        this.phonenumber = phonenumber;
        this.country = country;
        this.postalcode = postalcode;
        this.city = city;
        this.street = street;
        this.streetnumber = streetnumber;
        this.birthday = birthday;
        this.openinghours = openinghours;
        this.homepage = homepage;
        this.discriminator = discriminator;
        this.email = email;
    }

}