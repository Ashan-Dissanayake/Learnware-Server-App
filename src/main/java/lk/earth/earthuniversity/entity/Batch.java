package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.earth.earthuniversity.util.RegexPattern;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Batch {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Pattern(regexp = "^[A-Z][0-9]{3}$", message = "Invalid Number")
    @Column(name = "number")
    private String number;
    @Basic
    @Column(name = "name")
//    @Pattern(regexp = "^([A-Z]{3}[0-9]{2})$", message = "Invalid name")
    private String name;
    @Basic//
    @RegexPattern(reg = "^\\d{2}-\\d{2}-\\d{2}$", msg = "Invalid Date Format")
    @Column(name = "dostart")
    private Date dostart;
    @Basic
    @RegexPattern(reg = "^\\d{2}-\\d{2}-\\d{2}$", msg = "Invalid Date Format")
    @Column(name = "doend")
    private Date doend;
    @Basic
    @Column(name = "tostart")
    private Time tostart;
    @Basic
    @Column(name = "tofinish")
    private Time tofinish;
    @Basic
    @Pattern(regexp = "^.*$", message = "Invalid Description")
    @Column(name = "description")
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

    public Batch(int id,String name){
        this.id = id;
        this.name=name;
    }

    public Batch(){ }




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
        return Objects.equals(id, batch.id) && Objects.equals(number, batch.number) && Objects.equals(name, batch.name) && Objects.equals(dostart, batch.dostart) && Objects.equals(doend, batch.doend) && Objects.equals(tostart, batch.tostart) && Objects.equals(tofinish, batch.tofinish) && Objects.equals(description, batch.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, name, dostart, doend, tostart, tofinish, description);
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
}
