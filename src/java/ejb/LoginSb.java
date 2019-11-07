package ejb;

import entity.TUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author WITC_NP02410A
 */
@Stateless
public class LoginSb {

    @PersistenceContext
    //エンティティマネージャを生成 
    private EntityManager em;

    //主キーを検索するメソッド
    public TUser  find(String _paramString){
        return em.find(TUser.class, _paramString);
    }
    
    //項目を取得するメソッド
    public List<TUser> getAll(){
        return em.createNamedQuery("TUser.findAll").getResultList();
    }
    
}
