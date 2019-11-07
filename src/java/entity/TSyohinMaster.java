package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rie Matsui 
 * @since 20170315
 * @version 01
 */
@Entity
@Table(name = "t_syohin_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSyohinMaster.findAll", query = "SELECT t FROM TSyohinMaster t"),
    @NamedQuery(name = "TSyohinMaster.findBySyohinId", query = "SELECT t FROM TSyohinMaster t WHERE t.syohinId = :syohinId"),
    @NamedQuery(name = "TSyohinMaster.findBySyohinName", query = "SELECT t FROM TSyohinMaster t WHERE t.syohinName = :syohinName"),
    @NamedQuery(name = "TSyohinMaster.findByShiirekingaku", query = "SELECT t FROM TSyohinMaster t WHERE t.shiirekingaku = :shiirekingaku"),
    @NamedQuery(name = "TSyohinMaster.findByUriagekingakiu", query = "SELECT t FROM TSyohinMaster t WHERE t.uriagekingakiu = :uriagekingakiu"),
    @NamedQuery(name = "TSyohinMaster.findByCreateDate", query = "SELECT t FROM TSyohinMaster t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TSyohinMaster.findByCreateUser", query = "SELECT t FROM TSyohinMaster t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TSyohinMaster.findSyohinIdAll", query = "SELECT t.syohinId FROM TSyohinMaster t"),
    //商品名を検索しすべて取得する
    @NamedQuery(name = "TSyohinMaster.findSyohinNameAll", query = "SELECT t.syohinName FROM TSyohinMaster t"),
    //名前付query　件数を取得する
    @NamedQuery(name = "TSyohinMaster.count", query = "SELECT COUNT(t) FROM TSyohinMaster t")})
public class TSyohinMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SYOHIN_ID")
    private String syohinId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SYOHIN_NAME")
    private String syohinName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SHIIREKINGAKU")
    private int shiirekingaku;
    @Basic(optional = false)
    @NotNull
    @Column(name = "URIAGEKINGAKIU")
    private int uriagekingakiu;
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
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID")
    @ManyToOne(optional = false)
    private TCategoryMaster categoryId;

    public TSyohinMaster() {
    }

    public TSyohinMaster(String syohinId) {
        this.syohinId = syohinId;
    }

    public TSyohinMaster(String syohinId,TCategoryMaster categoryId,String syohinName,int shiirekingaku, int uriagekingakiu, Date createDate, String createUser) {
   
        this.syohinId = syohinId;
        this.categoryId = categoryId;
        this.syohinName = syohinName;
        this.shiirekingaku = shiirekingaku;
        this.uriagekingakiu = uriagekingakiu;
        this.createDate = createDate;
        this.createUser = createUser;
    }

    public String getSyohinId() {
        return syohinId;
    }

    public void setSyohinId(String syohinId) {
        this.syohinId = syohinId;
    }

    public String getSyohinName() {
        return syohinName;
    }

    public void setSyohinName(String syohinName) {
        this.syohinName = syohinName;
    }

    public int getShiirekingaku() {
        return shiirekingaku;
    }

    public void setShiirekingaku(int shiirekingaku) {
        this.shiirekingaku = shiirekingaku;
    }

    public int getUriagekingakiu() {
        return uriagekingakiu;
    }

    public void setUriagekingakiu(int uriagekingakiu) {
        this.uriagekingakiu = uriagekingakiu;
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

    public TCategoryMaster getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(TCategoryMaster categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (syohinId != null ? syohinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSyohinMaster)) {
            return false;
        }
        TSyohinMaster other = (TSyohinMaster) object;
        if ((this.syohinId == null && other.syohinId != null) || (this.syohinId != null && !this.syohinId.equals(other.syohinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TSyohinMaster[ syohinId=" + syohinId + " ]";
    }
    
}
