package com.greco.imagetag.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private int id;

    private String bucket;

    private String objectkey;

    private String objectkeysha1;

    //bi-directional many-to-one association to Imagelabel
    @OneToMany(mappedBy="image")
    private List<Imagelabel> imagelabels;

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

    public List<Imagelabel> getImagelabels() {
        return this.imagelabels;
    }

    public void setImagelabels(List<Imagelabel> imagelabels) {
        this.imagelabels = imagelabels;
    }

    public Imagelabel addImagelabel(Imagelabel imagelabel) {
        getImagelabels().add(imagelabel);
        imagelabel.setImage(this);

        return imagelabel;
    }

    public Imagelabel removeImagelabel(Imagelabel imagelabel) {
        getImagelabels().remove(imagelabel);
        imagelabel.setImage(null);

        return imagelabel;
    }


}