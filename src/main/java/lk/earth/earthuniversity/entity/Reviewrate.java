package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Reviewrate {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "rate")
    private Integer rate;
    @JsonIgnore
    @OneToMany(mappedBy = "reviewrate")
    private Collection<Classreview> classreviews;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reviewrate that = (Reviewrate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }

    public Collection<Classreview> getClassreviews() {
        return classreviews;
    }

    public void setClassreviews(Collection<Classreview> classreviews) {
        this.classreviews = classreviews;
    }
}
