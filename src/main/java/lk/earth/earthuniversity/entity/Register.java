package lk.earth.earthuniversity.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
public class Register {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "no")
    @Pattern(regexp = "^R\\d{7}$", message = "Invalid Number")
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

        if (id != null ? !id.equals(register.id) : register.id != null) return false;
        if (no != null ? !no.equals(register.no) : register.no != null) return false;
        if (date != null ? !date.equals(register.date) : register.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (no != null ? no.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
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
