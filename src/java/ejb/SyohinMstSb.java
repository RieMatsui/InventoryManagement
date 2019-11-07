package ejb;


import entity.TSyohinMaster;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author WITC_RieMatsui
 */
@Stateless
public class SyohinMstSb {
    
    @PersistenceContext
    //エンティティマネージャを生成
    private EntityManager em;
    
    //商品マスタを登録するたメソッド
    public void create(TSyohinMaster tSyohinMaster){
        em.persist(tSyohinMaster);
    }
    /**
     * 
     * @return List：商品マスタテーブルのデータを取得するメソッド
     * 商品マスタテーブルのデータを取得するメソッド
     */
    public List<TSyohinMaster> getAll(){
        return em.createNamedQuery("TSyohinMaster.findAll").getResultList();
    }
    /**
     * 
     * @return 
     * 商品マスタの主キーを検索するメソッド
     */
    public List<TSyohinMaster> getId(){
     return em.createNamedQuery("TSyohinMaster.findSyohinIdAll").getResultList();
    }
    /**
     * 
     * @return 
     * 商品名を検索するためのメソッド
     */  
    public List<TSyohinMaster> getShohinName(){
        return em.createNamedQuery("TSyohinMaster.findSyohinNameAll").getResultList();
    }
    //データの件数を表示する
    /**
     * 
     * @return 
     */
    public long dataCount(){
        
         long lg = 0;
         
         try {
            lg = (long) em.createNamedQuery("TSyohinMaster.count").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return lg;
    }
    
    
    public void getList(List<TSyohinMaster> _parmList){
        Iterator<TSyohinMaster> ite= getId().iterator();
        while (ite.hasNext()) {
            
        }
        
    }
    
}