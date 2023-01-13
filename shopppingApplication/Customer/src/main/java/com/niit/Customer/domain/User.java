
package com.niit.Customer.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class User {
    @Id
    private String email;
    private String passWord;
    private String firstName;
    private String lastName;
    private Product product;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", product=" + product +
                '}';
    }

    public User() {
    }


    public User(String email, String passWord, String firstName, String lastName, Product product) {
        this.email = email;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
        this.product = product;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(passWord, user.passWord) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(product, user.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, passWord, firstName, lastName, product);
    }
}
