package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author matsuirie
 */
@Entity
@Table(name = "t_uriage_amount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUriageAmount.findAll", query = "SELECT t FROM TUriageAmount t")
    , @NamedQuery(name = "TUriageAmount.findByUriageDate", query = "SELECT t FROM TUriageAmount t WHERE t.uriageDate = :uriageDate")
    , @NamedQuery(name = "TUriageAmount.findBySyohinId", query = "SELECT t FROM TUriageAmount t WHERE t.syohinId = :syohinId")
    , @NamedQuery(name = "TUriageAmount.findByUriageNum", query = "SELECT t FROM TUriageAmount t WHERE t.uriageNum = :uriageNum")
    , @NamedQuery(name = "TUriageAmount.findByCreateDate", query = "SELECT t FROM TUriageAmount t WHERE t.createDate = :createDate")
    , @NamedQuery(name = "TUriageAmount.findByCrearteUser", query = "SELECT t FROM TUriageAmount t WHERE t.crearteUser = :crearteUser")
    , @NamedQuery(name = "TUriageAmount.getUriageKobetsu", query = "SELECT SUM(t.uriageNum) FROM TUriageAmount t GROUP BY t.syohinId HAVING t.syohinId = :syohinId")} )
public class TUriageAmount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "URIAGE_DATE")
    private String uriageDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SYOHIN_ID")
    private String syohinId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "URIAGE_NUM")
    private int uriageNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CREARTE_USER")
    private String crearteUser;

    public TUriageAmount() {
    }

    public TUriageAmount(String uriageDate) {
        this.uriageDate = uriageDate;
    }

    public TUriageAmount(String uriageDate, String syohinId, int uriageNum, Date createDate, String crearteUser) {
        this.uriageDate = uriageDate;
        this.syohinId = syohinId;
        this.uriageNum = uriageNum;
        this.createDate = createDate;
        this.crearteUser = crearteUser;
    }

    public String getUriageDate() {
        return uriageDate;
    }

    public void setUriageDate(String uriageDate) {
        this.uriageDate = uriageDate;
    }

    public String getSyohinId() {
        return syohinId;
    }

    public void setSyohinId(String syohinId) {
        this.syohinId = syohinId;
    }

    public int getUriageNum() {
        return uriageNum;
    }

    public void setUriageNum(int uriageNum) {
        this.uriageNum = uriageNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCrearteUser() {
        return crearteUser;
    }

    public void setCrearteUser(String crearteUser) {
        this.crearteUser = crearteUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uriageDate != null ? uriageDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUriageAmount)) {
            return false;
        }
        TUriageAmount other = (TUriageAmount) object;
        if ((this.uriageDate == null && other.uriageDate != null) || (this.uriageDate != null && !this.uriageDate.equals(other.uriageDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TUriageAmount[ uriageDate=" + uriageDate + " ]";
    }
    
}
