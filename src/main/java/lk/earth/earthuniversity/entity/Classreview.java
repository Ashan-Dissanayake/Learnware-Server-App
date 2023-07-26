package lk.earth.earthuniversity.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

@Entity
public class Classreview {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "doreview")
    private Date doreview;
    @Basic
    @Column(name = "toreview")
    private Time toreview;
    @Basic
    @Column(name = "remarks")
    private String remarks;
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    private Clazz clazz;
    @ManyToOne
    @JoinColumn(name = "reviewrate_id", referencedColumnName = "id", nullable = false)
    private Reviewrate reviewrate;
    @OneToMany(mappedBy = "classreview")
    private Collection<Reviewtopic> reviewtopics;
    @ManyToOne
    @JoinColumn(name = "timelost_id", referencedColumnName = "id")
    private Timelost timelost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDoreview() {
        return doreview;
    }

    public void setDoreview(Date doreview) {
        this.doreview = doreview;
    }

    public Time getToreview() {
        return toreview;
    }

    public void setToreview(Time toreview) {
        this.toreview = toreview;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classreview that = (Classreview) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (doreview != null ? !doreview.equals(that.doreview) : that.doreview != null) return false;
        if (toreview != null ? !toreview.equals(that.toreview) : that.toreview != null) return false;
        if (remarks != null ? !remarks.equals(that.remarks) : that.remarks != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (doreview != null ? doreview.hashCode() : 0);
        result = 31 * result + (toreview != null ? toreview.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        return result;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Reviewrate getReviewrate() {
        return reviewrate;
    }

    public void setReviewrate(Reviewrate reviewrate) {
        this.reviewrate = reviewrate;
    }

    public Collection<Reviewtopic> getReviewtopics() {
        return reviewtopics;
    }

    public void setReviewtopics(Collection<Reviewtopic> reviewtopics) {
        this.reviewtopics = reviewtopics;
    }

    public Timelost getTimelost() {
        return timelost;
    }

    public void setTimelostB(Timelost timelost) {
        this.timelost = timelost;
    }
}
