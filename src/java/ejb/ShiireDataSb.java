package ejb;

import entity.TShiireAmount;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author WITC_RieMastui
 */
@Stateless
public class ShiireDataSb {
    @PersistenceContext
    //エンティティマネージャを生成
    private EntityManager em;
    /**
     * 
     * @param tShiireAmount 
     * 引数として仕入データデーブルに登録するデータを取得し
     * データベースに接続する
     */
    public void create(TShiireAmount tShiireAmount){
        em.persist(tShiireAmount);
    }
    /**
     * 
     * @param tShiireAmount
     * @return 
     * 取得したテーブルから個別データを取得するためのメソッド
     * （未完成）
     */
    public long dataCount(String syohinId){
        return (long) em.createNamedQuery("TShiireAmount.getNyukaNumKobetsu").setParameter("syohinId",syohinId).getSingleResult();
    }
   
}
