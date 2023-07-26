package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "fullname")
    @Pattern(regexp = "^([A-Z][a-z]*[.]?[\\s]?)*([A-Z][a-z]*)$", message = "Invalid Fullname")
    private String fullname;
    @Basic
    @Column(name = "name")
    @Pattern(regexp = "^([A-Z][a-z]+)$", message = "Invalid name")
    private String name;
    @Basic
    @Column(name = "callingname")
    @Pattern(regexp = "^([A-Z][a-z]+)$", message = "Invalid Calligname")
    private String callingname;
    @Basic
    @Column(name = "address")
    @Pattern(regexp = "^([\\w\\/\\-,\\s]{2,})$", message = "Invalid Address")
    private String address;
    @Basic
    @Column(name = "phoneno")
    @Pattern(regexp = "^0\\d{9}$", message = "Invalid Phone Number")
    private String phoneno;
    @Basic
    @Column(name = "dob")
    private Date dob;
    @Basic
    @Column(name = "gaurdiantype")
    @Pattern(regexp = "^([A-Z][a-z]+)$", message = "Invalid Guardian Name")
    private String gaurdianName;
    @Basic
    @Column(name = "emergencyno")
    @Pattern(regexp = "^0\\d{9}$", message = "Invalid Emergency Number")
    private String emergencyno;
    @Basic
    @Column(name = "description")
    @Pattern(regexp = "^.*$", message = "Invalid Description")
    private String description;
    @Basic
    @Column(name = "doregisterd")
    private Date doregisterd;
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private Collection<Register> registers;
    @ManyToOne
    @JoinColumn(name = "gaurdiantype_id", referencedColumnName = "id", nullable = false)
    private Gaurdiantype gaurdiantype;
    @ManyToOne
    @JoinColumn(name = "studentstatus_id", referencedColumnName = "id", nullable = false)
    private Studentstatus studentstatus;
    @OneToMany(mappedBy = "student")
    private Collection<Register> registersById;;

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

    public String getGaurdianName() {
        return gaurdianName;
    }

    public void setGaurdianName(String gaurdianName) {
        this.gaurdianName = gaurdianName;
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

        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        if (fullname != null ? !fullname.equals(student.fullname) : student.fullname != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (callingname != null ? !callingname.equals(student.callingname) : student.callingname != null) return false;
        if (address != null ? !address.equals(student.address) : student.address != null) return false;
        if (phoneno != null ? !phoneno.equals(student.phoneno) : student.phoneno != null) return false;
        if (dob != null ? !dob.equals(student.dob) : student.dob != null) return false;
        if (gaurdianName != null ? !gaurdianName.equals(student.gaurdianName) : student.gaurdianName != null)
            return false;
        if (emergencyno != null ? !emergencyno.equals(student.emergencyno) : student.emergencyno != null) return false;
        if (description != null ? !description.equals(student.description) : student.description != null) return false;
        if (doregisterd != null ? !doregisterd.equals(student.doregisterd) : student.doregisterd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (callingname != null ? callingname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneno != null ? phoneno.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (gaurdianName != null ? gaurdianName.hashCode() : 0);
        result = 31 * result + (emergencyno != null ? emergencyno.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (doregisterd != null ? doregisterd.hashCode() : 0);
        return result;
    }

    public Collection<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(Collection<Register> registers) {
        this.registers = registers;
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

    public Collection<Register> getRegistersById() {
        return registersById;
    }

    public void setRegistersById(Collection<Register> registersById) {
        this.registersById = registersById;
    }
}
