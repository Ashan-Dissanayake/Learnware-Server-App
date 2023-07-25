package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "dointroduced")
    private Date dointroduced;
    @Basic
    @Column(name = "credit")
    private Integer credit;
    @Basic
    @Column(name = "fee")
    private BigDecimal fee;
    @Basic
    @Column(name = "durationtheory")
    private Integer durationtheory;
    @Basic
    @Column(name = "durationpractical")
    private Integer durationpractical;
    @ManyToOne
    @JoinColumn(name = "coursecategory_id", referencedColumnName = "id", nullable = false)
    private Coursecategory coursecategoryByCoursecategoryId;
    @ManyToOne
    @JoinColumn(name = "cordinator_id", referencedColumnName = "id", nullable = false)
    private Employee employeeByCordinatorId;
    @ManyToOne
    @JoinColumn(name = "deputycordinator_id", referencedColumnName = "id", nullable = false)
    private Employee employeeByDeputycordinatorId;
    @ManyToOne
    @JoinColumn(name = "coursestatus_id", referencedColumnName = "id", nullable = false)
    private Coursestatus coursestatusByCoursestatusId;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Collection<Batch> batches;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Collection<Lesson> lessons;

    public Course(){ }

    public Course(int id,String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDointroduced() {
        return dointroduced;
    }

    public void setDointroduced(Date dointroduced) {
        this.dointroduced = dointroduced;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Integer getDurationtheory() {
        return durationtheory;
    }

    public void setDurationtheory(Integer durationtheory) {
        this.durationtheory = durationtheory;
    }

    public Integer getDurationpractical() {
        return durationpractical;
    }

    public void setDurationpractical(Integer durationpractical) {
        this.durationpractical = durationpractical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != null ? !id.equals(course.id) : course.id != null) return false;
        if (code != null ? !code.equals(course.code) : course.code != null) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (description != null ? !description.equals(course.description) : course.description != null) return false;
        if (dointroduced != null ? !dointroduced.equals(course.dointroduced) : course.dointroduced != null)
            return false;
        if (credit != null ? !credit.equals(course.credit) : course.credit != null) return false;
        if (fee != null ? !fee.equals(course.fee) : course.fee != null) return false;
        if (durationtheory != null ? !durationtheory.equals(course.durationtheory) : course.durationtheory != null)
            return false;
        if (durationpractical != null ? !durationpractical.equals(course.durationpractical) : course.durationpractical != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dointroduced != null ? dointroduced.hashCode() : 0);
        result = 31 * result + (credit != null ? credit.hashCode() : 0);
        result = 31 * result + (fee != null ? fee.hashCode() : 0);
        result = 31 * result + (durationtheory != null ? durationtheory.hashCode() : 0);
        result = 31 * result + (durationpractical != null ? durationpractical.hashCode() : 0);
        return result;
    }

    public Coursecategory getCoursecategoryByCoursecategoryId() {
        return coursecategoryByCoursecategoryId;
    }

    public void setCoursecategoryByCoursecategoryId(Coursecategory coursecategoryByCoursecategoryId) {
        this.coursecategoryByCoursecategoryId = coursecategoryByCoursecategoryId;
    }

    public Employee getEmployeeByCordinatorId() {
        return employeeByCordinatorId;
    }

    public void setEmployeeByCordinatorId(Employee employeeByCordinatorId) {
        this.employeeByCordinatorId = employeeByCordinatorId;
    }

    public Employee getEmployeeByDeputycordinatorId() {
        return employeeByDeputycordinatorId;
    }

    public void setEmployeeByDeputycordinatorId(Employee employeeByDeputycordinatorId) {
        this.employeeByDeputycordinatorId = employeeByDeputycordinatorId;
    }

    public Coursestatus getCoursestatusByCoursestatusId() {
        return coursestatusByCoursestatusId;
    }

    public void setCoursestatusByCoursestatusId(Coursestatus coursestatusByCoursestatusId) {
        this.coursestatusByCoursestatusId = coursestatusByCoursestatusId;
    }

    public Collection<Batch> getBatches() {
        return batches;
    }

    public void setBatches(Collection<Batch> batches) {
        this.batches = batches;
    }

    public Collection<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Collection<Lesson> lessons) {
        this.lessons = lessons;
    }
}
