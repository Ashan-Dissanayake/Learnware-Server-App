package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "class", schema = "learnware", catalog = "")
public class Clazz {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "doclass")
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
    private Date dodefine;
    @ManyToOne
    @JoinColumn(name = "batch_id", referencedColumnName = "id", nullable = false)
    private Batch batch;
    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id", nullable = false)
    private Lesson lesson;
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    private Employee teacher;
    @ManyToOne
    @JoinColumn(name = "classstatus_id", referencedColumnName = "id", nullable = false)
    private Classstatus classstatus;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee scheduler;
    @JsonIgnore
    @OneToMany(mappedBy = "clazz")
    private Collection<Classreview> classreviews;

    public Clazz() {};

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clazz clazz = (Clazz) o;

        if (id != null ? !id.equals(clazz.id) : clazz.id != null) return false;
        if (doclass != null ? !doclass.equals(clazz.doclass) : clazz.doclass != null) return false;
        if (tostart != null ? !tostart.equals(clazz.tostart) : clazz.tostart != null) return false;
        if (toend != null ? !toend.equals(clazz.toend) : clazz.toend != null) return false;
        if (description != null ? !description.equals(clazz.description) : clazz.description != null) return false;
        if (dodefine != null ? !dodefine.equals(clazz.dodefine) : clazz.dodefine != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (doclass != null ? doclass.hashCode() : 0);
        result = 31 * result + (tostart != null ? tostart.hashCode() : 0);
        result = 31 * result + (toend != null ? toend.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dodefine != null ? dodefine.hashCode() : 0);
        return result;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
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

    public Employee getScheduler() {
        return scheduler;
    }

    public void setScheduler(Employee scheduler) {
        this.scheduler = scheduler;
    }

    public Collection<Classreview> getClassreviews() {
        return classreviews;
    }

    public void setClassreviews(Collection<Classreview> classreviews) {
        this.classreviews = classreviews;
    }
}
