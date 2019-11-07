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
 * @author WITC_NP02410A
 */
@Entity
@Table(name = "t_user", catalog = "witc_zaikoApp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUser.findAll", query = "SELECT t FROM TUser t"),
    @NamedQuery(name = "TUser.findByUserId", query = "SELECT t FROM TUser t WHERE t.userId = :userId"),
    @NamedQuery(name = "TUser.findByUserPassword", query = "SELECT t FROM TUser t WHERE t.userPassword = :userPassword"),
    @NamedQuery(name = "TUser.findByCreateDate", query = "SELECT t FROM TUser t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TUser.findByCreateUser", query = "SELECT t FROM TUser t WHERE t.createUser = :createUser")})
public class TUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "USER_ID")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "USER_PASSWORD")
    private String userPassword;
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

    public TUser() {
    }

    public TUser(String userId) {
        this.userId = userId;
    }

    public TUser( String userId, String userPassword, Date createDate, String createUser) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.createDate = createDate;
        this.createUser = createUser;
    }
    
    public TUser(String usrId,String userPassword){
        this.userId = usrId;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUser)) {
            return false;
        }
        TUser other = (TUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TUser[ userId=" + userId + " ]";
    }
    
}
