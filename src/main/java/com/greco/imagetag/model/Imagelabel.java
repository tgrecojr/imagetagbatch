package com.greco.imagetag.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the imagelabels database table.
 *
 */
@Entity
@Table(name="imagelabels")
@NamedQuery(name="Imagelabel.findAll", query="SELECT i FROM Imagelabel i")
public class Imagelabel implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ImagelabelPK id;

    private float confidence;

    //bi-directional many-to-one association to Image
    @ManyToOne
    @JoinColumn(name="imageid")
    private Image image;

    //bi-directional many-to-one association to Label
    @ManyToOne
    @JoinColumn(name="lableid")
    private Label label;

    public Imagelabel() {
    }

    public ImagelabelPK getId() {
        return this.id;
    }

    public void setId(ImagelabelPK id) {
        this.id = id;
    }

    public float getConfidence() {
        return this.confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Label getLabel() {
        return this.label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

}