package com.greco.imagetag.model;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the labels database table.
 *
 */
@Entity
@Table(name="labels")
@NamedQuery(name="Label.findAll", query="SELECT l FROM Label l")
public class Label implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    private String labelname;

    //bi-directional many-to-one association to Imagelabel
    @OneToMany(mappedBy="label")
    private List<Imagelabel> imagelabels;

    public Label() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabelname() {
        return this.labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public List<Imagelabel> getImagelabels() {
        return this.imagelabels;
    }

    public void setImagelabels(List<Imagelabel> imagelabels) {
        this.imagelabels = imagelabels;
    }

    public Imagelabel addImagelabel(Imagelabel imagelabel) {
        getImagelabels().add(imagelabel);
        imagelabel.setLabel(this);

        return imagelabel;
    }

    public Imagelabel removeImagelabel(Imagelabel imagelabel) {
        getImagelabels().remove(imagelabel);
        imagelabel.setLabel(null);

        return imagelabel;
    }

}