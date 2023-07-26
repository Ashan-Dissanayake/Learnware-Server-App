package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "number")
    @Pattern(regexp = "^\\d{4}$", message = "Invalid Number")
    private String number;
    @Basic
    @Column(name = "fullname")
    @Pattern(regexp = "^([A-Z][a-z]*[.]?[\\s]?)*([A-Z][a-z]*)$", message = "Invalid Fullname")
    private String fullname;
    @Basic
    @Column(name = "callingname")
    @Pattern(regexp = "^([A-Z][a-z]+)$", message = "Invalid Calligname")
    private String callingname;
    @Basic
    @Column(name = "photo")
    private byte[] photo;
    @Basic
    @Column(name = "dobirth")
    private Date dobirth;
    @Basic
    @Column(name = "nic")
    @Pattern(regexp = "^(([\\d]{9}[vVxX])|([\\d]{12}))$", message = "Invalid NIC")
    private String nic;
    @Basic
    @Column(name = "address")
    @Pattern(regexp = "^([\\w\\/\\-,\\s]{2,})$", message = "Invalid Address")
    private String address;
    @Basic
    @Column(name = "mobile")
    @Pattern(regexp = "^0\\d{9}$", message = "Invalid Mobilephone Number")
    private String mobile;
    @Basic
    @Column(name = "land")
    @Pattern(regexp = "^\\d{0,10}$", message = "Invalid Landphone Number")
    private String land;
    @Basic
    @Column(name = "doassignment")
    private Date doassignment;
    @Basic
    @Column(name = "description")
    @Pattern(regexp = "^.*$", message = "Invalid Description")
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Collection<Batch> batches;
    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Collection<Clazz> clazzesTeacher;
    @JsonIgnore
    @OneToMany(mappedBy = "scheduler")
    private Collection<Clazz> clazzesSheduler;
    @JsonIgnore
    @OneToMany(mappedBy = "cordinator")
    private Collection<Course> coursesCordinator;
    @JsonIgnore
    @OneToMany(mappedBy = "deputycordinator")
    private Collection<Course> coursesDptCordinator;
    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false)
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "designation_id", referencedColumnName = "id", nullable = false)
    private Designation designation;
    @ManyToOne
    @JoinColumn(name = "employeestatus_id", referencedColumnName = "id", nullable = false)
    private Employeestatus employeestatus;
    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Collection<Register> registers;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Collection<User> users;

    public Employee(){};

    public Employee(int id,String callingname){
        this.id = id;
        this.callingname = callingname;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCallingname() {
        return callingname;
    }

    public void setCallingname(String callingname) {
        this.callingname = callingname;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Date getDobirth() {
        return dobirth;
    }

    public void setDobirth(Date dobirth) {
        this.dobirth = dobirth;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public Date getDoassignment() {
        return doassignment;
    }

    public void setDoassignment(Date doassignment) {
        this.doassignment = doassignment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (number != null ? !number.equals(employee.number) : employee.number != null) return false;
        if (fullname != null ? !fullname.equals(employee.fullname) : employee.fullname != null) return false;
        if (callingname != null ? !callingname.equals(employee.callingname) : employee.callingname != null)
            return false;
        if (!Arrays.equals(photo, employee.photo)) return false;
        if (dobirth != null ? !dobirth.equals(employee.dobirth) : employee.dobirth != null) return false;
        if (nic != null ? !nic.equals(employee.nic) : employee.nic != null) return false;
        if (address != null ? !address.equals(employee.address) : employee.address != null) return false;
        if (mobile != null ? !mobile.equals(employee.mobile) : employee.mobile != null) return false;
        if (land != null ? !land.equals(employee.land) : employee.land != null) return false;
        if (doassignment != null ? !doassignment.equals(employee.doassignment) : employee.doassignment != null)
            return false;
        if (description != null ? !description.equals(employee.description) : employee.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (callingname != null ? callingname.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + (dobirth != null ? dobirth.hashCode() : 0);
        result = 31 * result + (nic != null ? nic.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (land != null ? land.hashCode() : 0);
        result = 31 * result + (doassignment != null ? doassignment.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<Batch> getBatches() {
        return batches;
    }

    public void setBatches(Collection<Batch> batches) {
        this.batches = batches;
    }

    public Collection<Clazz> getClazzesTeacher() {
        return clazzesTeacher;
    }

    public void setClazzesTeacher(Collection<Clazz> clazzesTeacher) {
        this.clazzesTeacher = clazzesTeacher;
    }

    public Collection<Clazz> getClazzesSheduler() {
        return clazzesSheduler;
    }

    public void setClazzesSheduler(Collection<Clazz> clazzesSheduler) {
        this.clazzesSheduler = clazzesSheduler;
    }

    public Collection<Course> getCoursesCordinator() {
        return coursesCordinator;
    }

    public void setCoursesCordinator(Collection<Course> coursesCordinator) {
        this.coursesCordinator = coursesCordinator;
    }

    public Collection<Course> getCoursesDptCordinator() {
        return coursesDptCordinator;
    }

    public void setCoursesDptCordinator(Collection<Course> coursesDptCordinator) {
        this.coursesDptCordinator = coursesDptCordinator;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Employeestatus getEmployeestatus() {
        return employeestatus;
    }

    public void setEmployeestatus(Employeestatus employeestatus) {
        this.employeestatus = employeestatus;
    }

    public Collection<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(Collection<Register> registers) {
        this.registers = registers;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
