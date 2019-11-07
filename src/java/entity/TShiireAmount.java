
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
 * @author Rie Matsui 
 * @since 20170315
 * @version 01
 */
@Entity
@Table(name = "t_shiire_amount", catalog = "witc_zaikoApp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TShiireAmount.findAll", query = "SELECT t FROM TShiireAmount t"),
    @NamedQuery(name = "TShiireAmount.findByShiireDate", query = "SELECT t FROM TShiireAmount t WHERE t.shiireDate = :shiireDate"),
    @NamedQuery(name = "TShiireAmount.findBySyohinId", query = "SELECT t FROM TShiireAmount t WHERE t.syohinId = :syohinId"),
    @NamedQuery(name = "TShiireAmount.findByNyukaNum", query = "SELECT t FROM TShiireAmount t WHERE t.nyukaNum = :nyukaNum"),
    @NamedQuery(name = "TShiireAmount.findByCreateDate", query = "SELECT t FROM TShiireAmount t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TShiireAmount.findByCreateUser", query = "SELECT t FROM TShiireAmount t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TShiireAmount.getNyukaNumKobetsu", query = "SELECT SUM(t.nyukaNum) FROM TShiireAmount t GROUP BY t.syohinId HAVING t.syohinId = :syohinId")})

public class TShiireAmount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "SHIIRE_DATE")
    private String shiireDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SYOHIN_ID")
    private String syohinId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NYUKA_NUM")
    private int nyukaNum;
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

    public TShiireAmount() {
    }

    public TShiireAmount(String shiireDate) {
        this.shiireDate = shiireDate;
    }
    
    public TShiireAmount(String syohinId,String createUser){
        this.syohinId = syohinId;
        this.createUser = createUser;
    }


    public TShiireAmount(String shiireDate, String syohinId, int nyukaNum, Date createDate, String createUser) {
        this.shiireDate = shiireDate;
        this.syohinId = syohinId;
        this.nyukaNum = nyukaNum;
        this.createDate = createDate;
        this.createUser = createUser;
    }
    

    public String getShiireDate() {
        return shiireDate;
    }

    public void setShiireDate(String shiireDate) {
        this.shiireDate = shiireDate;
    }

    public String getSyohinId() {
        return syohinId;
    }

    public void setSyohinId(String syohinId) {
        this.syohinId = syohinId;
    }

    public int getNyukaNum() {
        return nyukaNum;
    }

    public void setNyukaNum(int nyukaNum) {
        this.nyukaNum = nyukaNum;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shiireDate != null ? shiireDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TShiireAmount)) {
            return false;
        }
        TShiireAmount other = (TShiireAmount) object;
        if ((this.shiireDate == null && other.shiireDate != null) || (this.shiireDate != null && !this.shiireDate.equals(other.shiireDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TShiireAmount[ shiireDate=" + shiireDate + " ]";
    }
    
}
