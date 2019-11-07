
package ejb;

import entity.TUriageAmount;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RieMatsui
 * @Since 2017/03/15
 * 
 */
@Stateless
public class UriageDataSb {

    //エンティティマネージャを生成
    @PersistenceContext
    private EntityManager em;
    //データベースに新規登録するためのメソッド
    /**
     * 
     * @param tUriageAmount 
     */
    public void create(TUriageAmount tUriageAmount){
        em.persist(tUriageAmount);
    }
    
    public long dataCount(String syohinId){
        return (long) em.createNamedQuery("TUriageAmount.getUriageKobetsu").setParameter("syohinId",syohinId).getSingleResult();
    }
}
