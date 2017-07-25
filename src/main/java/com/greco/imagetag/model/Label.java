package com.greco.imagetag.model;


import java.io.Serializable;
import javax.persistence.*;


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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String labelname;

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

}
