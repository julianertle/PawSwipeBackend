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
    @Column(name = "profileid")
    private int profileid;

    @Column(name = "username")
    private String username;

    public int getProfileid() {
        return profileid;
    }

    public void setProfileid(int profileid) {
        this.profileid = profileid;
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

    public byte[] getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(byte[] profilepicture) {
        this.profilepicture = profilepicture;
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

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOpeninghours() {
        return openinghours;
    }

    public void setOpeninghours(String openinghours) {
        this.openinghours = openinghours;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "profilepicture")
    private byte[] profilepicture;

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

    public Profile(String username, byte[] profilepicture, String description, String password, Date creationdate,
                   String phonenumber, String country, String postalcode, String city, String street,
                   String streetnumber, Date birthday, String openinghours, String homepage, String discriminator,
                   String email) {
        this.username = username;
        this.profilepicture = profilepicture;
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