package com.aeroparker.registration.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "customers",
        uniqueConstraints = @UniqueConstraint(columnNames = "email_address")
)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Will set on save in the controller/service
    @Column(nullable = false)
    private LocalDateTime registered;

    @NotBlank
    @Email
    @Size(max = 255)
    @Column(name = "email_address", nullable = false, length = 255)
    private String emailAddress;

    @NotBlank
    @Size(max = 5)
    private String title;

    @NotBlank
    @Size(max = 50)
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @NotBlank
    @Size(max = 255)
    @Column(name = "address_line_1", length = 255, nullable = false)
    private String addressLine1;

    @Size(max = 255)
    @Column(name = "address_line_2", length = 255)
    private String addressLine2;

    @Size(max = 255)
    private String city;

    @NotBlank
    @Size(max = 10)
    private String postcode;

    @Size(max = 20)
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    // Getters & setters…

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getRegistered() { return registered; }
    public void setRegistered(LocalDateTime registered) { this.registered = registered; }

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddressLine1() { return addressLine1; }
    public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }

    public String getAddressLine2() { return addressLine2; }
    public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPostcode() { return postcode; }
    public void setPostcode(String postcode) { this.postcode = postcode; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
