package lk.earth.earthuniversity.entity;

import lk.earth.earthuniversity.util.RegexPattern;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Pattern(regexp = "^([A-Z][a-z]*[.]?[\\s]?)*([A-Z][a-z]*)$", message = "Invalid Fullname")
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Pattern(regexp = "^([A-Z][a-z]+)$", message = "Invalid name")
    @Column(name = "name")
    private String name;
    @Basic
    @Pattern(regexp = "^([A-Z][a-z]+)$", message = "Invalid Calligname")
    @Column(name = "callingname")
    private String callingname;
    @Basic
    @Pattern(regexp = "^([\\w\\/\\-,\\s]{2,})$", message = "Invalid Address")
    @Column(name = "address")
    private String address;
    @Basic
    @Pattern(regexp = "^0\\d{9}$", message = "Invalid Mobile Number")
    @Column(name = "phoneno")
    private String phoneno;
    @Basic
    @RegexPattern(reg = "^\\d{2}-\\d{2}-\\d{2}$", msg = "Invalid Date Format")
    @Column(name = "dob")
    private Date dob;
    @Basic
    @Pattern(regexp = "^([A-Z][a-z]+)$", message = "Invalid guardianname")
    @Column(name = "gaurdiantype")
    private String gaurdianname;
    @Basic
    @Pattern(regexp = "^0\\d{9}$", message = "Invalid Emergency Number")
    @Column(name = "emergencyno")
    private String emergencyno;
    @Basic
    @Pattern(regexp = "^.*$", message = "Invalid Description")
    @Column(name = "description")
    private String description;
    @Basic
    @RegexPattern(reg = "^\\d{2}-\\d{2}-\\d{2}$", msg = "Invalid Date Format")
    @Column(name = "doregisterd")
    private Date doregisterd;
    @ManyToOne
    @JoinColumn(name = "gaurdiantype_id", referencedColumnName = "id", nullable = false)
    private Gaurdiantype gaurdiantype;
    @ManyToOne
    @JoinColumn(name = "studentstatus_id", referencedColumnName = "id", nullable = false)
    private Studentstatus studentstatus;

    public Student(){ }

    public Student(int id,String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCallingname() {
        return callingname;
    }

    public void setCallingname(String callingname) {
        this.callingname = callingname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGaurdianname() {
        return gaurdianname;
    }

    public void setGaurdianname(String gaurdianname) {
        this.gaurdianname = gaurdianname;
    }

    public String getEmergencyno() {
        return emergencyno;
    }

    public void setEmergencyno(String emergencyno) {
        this.emergencyno = emergencyno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDoregisterd() {
        return doregisterd;
    }

    public void setDoregisterd(Date doregisterd) {
        this.doregisterd = doregisterd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(fullname, student.fullname) && Objects.equals(name, student.name) && Objects.equals(callingname, student.callingname) && Objects.equals(address, student.address) && Objects.equals(phoneno, student.phoneno) && Objects.equals(dob, student.dob) && Objects.equals(gaurdianname, student.gaurdianname) && Objects.equals(emergencyno, student.emergencyno) && Objects.equals(description, student.description) && Objects.equals(doregisterd, student.doregisterd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, name, callingname, address, phoneno, dob, gaurdianname, emergencyno, description, doregisterd);
    }

    public Gaurdiantype getGaurdiantype() {
        return gaurdiantype;
    }

    public void setGaurdiantype(Gaurdiantype gaurdiantype) {
        this.gaurdiantype = gaurdiantype;
    }

    public Studentstatus getStudentstatus() {
        return studentstatus;
    }

    public void setStudentstatus(Studentstatus studentstatus) {
        this.studentstatus = studentstatus;
    }
}