package com.greco.imagetag.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the images database table.
 *
 */
@Entity
@Table(name="images")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String bucket;

    private String objectkey;

    private String objectkeysha1;

    //uni-directional many-to-many association to Label
    @ManyToMany
    @JoinTable(
            name="imagelabels"
            , joinColumns={
            @JoinColumn(name="imageid")
    }
            , inverseJoinColumns={
            @JoinColumn(name="lableid")
    }
    )
    private List<Label> labels;

    public Image() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBucket() {
        return this.bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getObjectkey() {
        return this.objectkey;
    }

    public void setObjectkey(String objectkey) {
        this.objectkey = objectkey;
    }

    public String getObjectkeysha1() {
        return this.objectkeysha1;
    }

    public void setObjectkeysha1(String objectkeysha1) {
        this.objectkeysha1 = objectkeysha1;
    }

    public List<Label> getLabels() {
        return this.labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

}