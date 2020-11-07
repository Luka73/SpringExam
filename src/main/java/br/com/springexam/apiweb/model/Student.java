package br.com.springexam.apiweb.model;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int studentId;
    private String firstName;
    private String lastName;
    private String city;
    private String program;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;

    public Student() {

    }

    public Student(int studentId, String firstName, String lastName, String city, String program) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.program = program;
    }

    public Student(int studentId, String firstName, String lastName, String city, String program, Address address) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.program = program;
        this.address = address;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
