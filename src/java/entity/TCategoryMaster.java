
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rie Matsui 
 * @since 20170315
 * @version 01
 */
@Entity
@Table(name = "t_category_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCategoryMaster.findAll", query = "SELECT t FROM TCategoryMaster t"),
    @NamedQuery(name = "TCategoryMaster.findByCategoryId", query = "SELECT t FROM TCategoryMaster t WHERE t.categoryId = :categoryId"),
    @NamedQuery(name = "TCategoryMaster.findByCategoryName", query = "SELECT t FROM TCategoryMaster t WHERE t.categoryName = :categoryName"),
    @NamedQuery(name = "TCategoryMaster.findByCreateDate", query = "SELECT t FROM TCategoryMaster t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TCategoryMaster.findByCreateUser", query = "SELECT t FROM TCategoryMaster t WHERE t.createUser = :createUser")})
public class TCategoryMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CATEGORY_ID")
    private String categoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CREATE_USER")
    private String createUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<TSyohinMaster> tSyohinMasterCollection;

    public TCategoryMaster() {
    }

    public TCategoryMaster(String categoryId) {
        this.categoryId = categoryId;
    }

    public TCategoryMaster(String categoryId, String categoryName, Date createDate, String createUser) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.createDate = createDate;
        this.createUser = createUser;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @XmlTransient
    public Collection<TSyohinMaster> getTSyohinMasterCollection() {
        return tSyohinMasterCollection;
    }

    public void setTSyohinMasterCollection(Collection<TSyohinMaster> tSyohinMasterCollection) {
        this.tSyohinMasterCollection = tSyohinMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCategoryMaster)) {
            return false;
        }
        TCategoryMaster other = (TCategoryMaster) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TCategoryMaster[ categoryId=" + categoryId + " ]";
    }
    
}
