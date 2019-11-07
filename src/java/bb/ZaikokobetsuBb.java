
package bb;

import ejb.ShiireDataSb;
import ejb.SyohinMstSb;
import ejb.UriageDataSb;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author matsuirie
 * @since 2017/03/16
 */
@Named
@RequestScoped
public class ZaikokobetsuBb implements Serializable{
    //商品ID
    private String syohinId;
    //在庫数
    private Long zaikoNum;
    //メニューバー
    private Integer menubar;
   
    //商品マスタのデータベース接続のクラス
    @EJB
    SyohinMstSb syohinMstSb;
    
    //仕入データのデータベース接続のためのクラス
    @EJB
    ShiireDataSb shiireDataSb;
    
    @EJB
    UriageDataSb uriageDataSb;
    
    
    
    //マップで商品名と商品IDをプルダウンで表示
    private static Map<String,Integer> syohinItems;
    
    //ページが読み込まれた時に処理
    @PostConstruct
    public void loadPage(){
        
         //商品名と商品IDをマップにセット
        syohinItems = new LinkedHashMap();
        //データ件数をデータベースから取得
        int num = (int)syohinMstSb.dataCount();
                for (int i = 1; i <= num ; i++){
                    //件数の数だけItemsを作成(登録されている商品IDと商品名を表示)
                    syohinItems.put(syohinMstSb.getId().get(i-1) + "\n" + syohinMstSb.getShohinName().get(i-1),i);
        }
    }
    //在庫数を表示するためのメソッド
    public  String getsyohinIdData(){
        
        //仕入個数(個別)
        long shiireNum = 0;
        //売上個数(個別)
        long uriageNum = 0;
        
        //取得したプルダウンから商品IDを取得する
        setSyohinId(String.valueOf(syohinMstSb.getId().get(menubar -1)));
   
        try {
            //仕入データの件数を表示
            shiireNum = shiireDataSb.dataCount(syohinId);
                       
        } catch (Exception e) {
            e.printStackTrace();
            //エラーが発生したときに値を0で返す
            shiireNum = 0;
        }       
        try {
            //売上データを表示
            uriageNum = uriageDataSb.dataCount(syohinId);
        } catch (Exception e) {
            //エラーが発生したときに値を0で返す
            uriageNum = 0;
        }
        // 在庫数　= 仕入在庫-売上数　で在庫数を計算
        zaikoNum = shiireNum - uriageNum;
        return null;
   
    }
    
    
    /**
     * 
     * @return 
     */
    public  Map<String, Integer> getShohinItems() {
        return syohinItems;
    }
    /**
     * 
     * @return 
     */
    public String getSyohinId() {
        return syohinId;
    }
    /**
     * 
     * @param syohinId 
     */
    public void setSyohinId(String syohinId) {
        this.syohinId = syohinId;
    }
    /**
     * 
     * @return 
     */
    public Long getZaikoNum() {
        return zaikoNum;
    }
    /**
     * 
     * @param zaikoNum 
     */
    public void setZaikoNum(Long zaikoNum) {
        this.zaikoNum = zaikoNum;
    }
    /**
     * 
     * @return 
     */
    public Integer getMenubar() {
        return menubar;
    }
    /**
     * 
     * @param menubar 
     */
    public void setMenubar(Integer menubar) {
        this.menubar = menubar;
    }
    
    
}
