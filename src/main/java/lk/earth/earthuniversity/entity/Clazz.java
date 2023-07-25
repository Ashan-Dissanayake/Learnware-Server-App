package lk.earth.earthuniversity.entity;
import lk.earth.earthuniversity.util.RegexPattern;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "class", schema = "learnware", catalog = "")
public class Clazz {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "doclass")
    @RegexPattern(reg = "^\\d{2}-\\d{2}-\\d{2}$", msg = "Invalid Date Format")
    private Date doclass;
    @Basic
    @Column(name = "tostart")
    private Time tostart;
    @Basic
    @Column(name = "toend")
    private Time toend;
    @Basic
    @Column(name = "description")
    @Pattern(regexp = "^.*$", message = "Invalid Description")
    private String description;
    @Basic
    @Column(name = "dodefine")
    @RegexPattern(reg = "^\\d{2}-\\d{2}-\\d{2}$", msg = "Invalid Date Format")
    private Date dodefine;
    @ManyToOne
    @JoinColumn(name = "batch_id", referencedColumnName = "id", nullable = false)
    private Batch batch;
    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id", nullable = false)
    private Lesson lessonByLessonId;
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    private Employee teacher;
    @ManyToOne
    @JoinColumn(name = "classstatus_id", referencedColumnName = "id", nullable = false)
    private Classstatus classstatus;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
    @OneToMany(mappedBy = "clazz")
    @JsonIgnore
    private Collection<Classreview> classreviews;

    public Clazz() {
    }

    public Clazz(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDoclass() {
        return doclass;
    }

    public void setDoclass(Date doclass) {
        this.doclass = doclass;
    }

    public Time getTostart() {
        return tostart;
    }

    public void setTostart(Time tostart) {
        this.tostart = tostart;
    }

    public Time getToend() {
        return toend;
    }

    public void setToend(Time toend) {
        this.toend = toend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDodefine() {
        return dodefine;
    }

    public void setDodefine(Date dodefine) {
        this.dodefine = dodefine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Clazz clazz = (Clazz) o;
        return Objects.equals(id, clazz.id) && Objects.equals(doclass, clazz.doclass)
                && Objects.equals(tostart, clazz.tostart) && Objects.equals(toend, clazz.toend)
                && Objects.equals(description, clazz.description) && Objects.equals(dodefine, clazz.dodefine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doclass, tostart, toend, description, dodefine);
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Lesson getLessonByLessonId() {
        return lessonByLessonId;
    }

    public void setLessonByLessonId(Lesson lessonByLessonId) {
        this.lessonByLessonId = lessonByLessonId;
    }

    public Employee getTeacher() {
        return teacher;
    }

    public void setTeacher(Employee teacher) {
        this.teacher = teacher;
    }

    public Classstatus getClassstatus() {
        return classstatus;
    }

    public void setClassstatus(Classstatus classstatus) {
        this.classstatus = classstatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Collection<Classreview> getClassreviews() {
        return classreviews;
    }

    public void setClassreviews(Collection<Classreview> classreviews) {
        this.classreviews = classreviews;
    }
}
