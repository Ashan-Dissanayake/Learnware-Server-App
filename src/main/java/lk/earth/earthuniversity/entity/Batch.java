package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

@Entity
public class Batch {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "number")
    @Pattern(regexp = "^[A-Z][0-9]{3}$", message = "Invalid Number")
    private String number;
    @Basic
    @Column(name = "name")
    @Pattern(regexp = "^([A-Z]{3}[0-9]{2})$", message = "Invalid name")
    private String name;
    @Basic
    @Column(name = "dostart")
    private Date dostart;
    @Basic
    @Column(name = "doend")
    private Date doend;
    @Basic
    @Column(name = "tostart")
    private Time tostart;
    @Basic
    @Column(name = "tofinish")
    private Time tofinish;
    @Basic
    @Column(name = "description")
    @Pattern(regexp = "^.*$", message = "Invalid Description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Course course;
    @ManyToOne
    @JoinColumn(name = "day_id", referencedColumnName = "id", nullable = false)
    private Day day;
    @ManyToOne
    @JoinColumn(name = "cordinator_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "batchstatus_id", referencedColumnName = "id", nullable = false)
    private Batchstatus batchstatus;
    @JsonIgnore
    @OneToMany(mappedBy = "batch")
    private Collection<Clazz> clazzes;
    @JsonIgnore
    @OneToMany(mappedBy = "batch")
    private Collection<Register> registers;

    public Batch(int id,String name){
        this.id = id;
        this.name=name;
    }

    public Batch(){ };

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDostart() {
        return dostart;
    }

    public void setDostart(Date dostart) {
        this.dostart = dostart;
    }

    public Date getDoend() {
        return doend;
    }

    public void setDoend(Date doend) {
        this.doend = doend;
    }

    public Time getTostart() {
        return tostart;
    }

    public void setTostart(Time tostart) {
        this.tostart = tostart;
    }

    public Time getTofinish() {
        return tofinish;
    }

    public void setTofinish(Time tofinish) {
        this.tofinish = tofinish;
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

        Batch batch = (Batch) o;

        if (id != null ? !id.equals(batch.id) : batch.id != null) return false;
        if (number != null ? !number.equals(batch.number) : batch.number != null) return false;
        if (name != null ? !name.equals(batch.name) : batch.name != null) return false;
        if (dostart != null ? !dostart.equals(batch.dostart) : batch.dostart != null) return false;
        if (doend != null ? !doend.equals(batch.doend) : batch.doend != null) return false;
        if (tostart != null ? !tostart.equals(batch.tostart) : batch.tostart != null) return false;
        if (tofinish != null ? !tofinish.equals(batch.tofinish) : batch.tofinish != null) return false;
        if (description != null ? !description.equals(batch.description) : batch.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dostart != null ? dostart.hashCode() : 0);
        result = 31 * result + (doend != null ? doend.hashCode() : 0);
        result = 31 * result + (tostart != null ? tostart.hashCode() : 0);
        result = 31 * result + (tofinish != null ? tofinish.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Batchstatus getBatchstatus() {
        return batchstatus;
    }

    public void setBatchstatus(Batchstatus batchstatus) {
        this.batchstatus = batchstatus;
    }

    public Collection<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(Collection<Clazz> clazzes) {
        this.clazzes = clazzes;
    }

    public Collection<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(Collection<Register> registers) {
        this.registers = registers;
    }
}
