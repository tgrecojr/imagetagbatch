package com.greco.imagetag.model;
import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the imagelabels database table.
 *
 */
@Embeddable
public class ImagelabelPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(insertable=false, updatable=false)
    private int imageid;

    @Column(insertable=false, updatable=false)
    private int lableid;

    public ImagelabelPK() {
    }
    public int getImageid() {
        return this.imageid;
    }
    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
    public int getLableid() {
        return this.lableid;
    }
    public void setLableid(int lableid) {
        this.lableid = lableid;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImagelabelPK)) {
            return false;
        }
        ImagelabelPK castOther = (ImagelabelPK)other;
        return
                (this.imageid == castOther.imageid)
                        && (this.lableid == castOther.lableid);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.imageid;
        hash = hash * prime + this.lableid;

        return hash;
    }
}