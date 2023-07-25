package lk.earth.earthuniversity.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Register {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "no")
    private Integer no;
    @Basic
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "batch_id", referencedColumnName = "id", nullable = false)
    private Batch batch;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "registrationstatus_id", referencedColumnName = "id", nullable = false)
    private Registrationstatus registrationstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Register register = (Register) o;
        return Objects.equals(id, register.id) && Objects.equals(no, register.no) && Objects.equals(date, register.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, no, date);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Registrationstatus getRegistrationstatus() {
        return registrationstatus;
    }

    public void setRegistrationstatus(Registrationstatus registrationstatus) {
        this.registrationstatus = registrationstatus;
    }
}
