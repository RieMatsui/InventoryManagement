package bb;

import ejb.ShiireDataSb;
import ejb.SyohinMstSb;
import entity.TShiireAmount;
import fw.DateFormatUtil;
import fw.UserDataUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

/**
 *
 * @author WITC_RieMatsui
 * @since 2017/0315
 * 
 */
@Named
@RequestScoped
public class ShiireData implements Serializable{
    
    //メンバ変数　仕入日
    @NotNull
    private Date shiireDate;
    //メンバ変数　入荷数
    @NotNull
    private Integer nyukaNum;
    //メンバ変数　メニューバーの表示
    private Integer menuber;
    //メンバ変数　商品ID
    private String syohinId;
    
    
    
    //商品IDと商品名の取得のためのEJBクラス
    @EJB
    SyohinMstSb syohinMstSb;
    //仕入れデータを新規登録するためのEJBクラス
    @EJB
    ShiireDataSb shiireDateSb;
    
    //ユーザ名のデータを取得するクラス
    @EJB
    UserDataUtil userDataUtil;
     
    //マップで商品名と商品IDを表示
    private static Map<String,Integer> syohinItems;
    
    //ページが読み込まれたときに処理
    @PostConstruct
    public void loadShiireData(){
        //商品名と商品IDをマップにセット
        syohinItems = new LinkedHashMap();
        //データ件数をデータベースから取得
        int num = (int)syohinMstSb.dataCount();
            for (int i = 1; i <= num ; i++){
                //件数の数だけItemsを作成(登録されている商品IDと商品名を表示)
                syohinItems.put(syohinMstSb.getId().get(i-1) + "\n" + syohinMstSb.getShohinName().get(i-1), i);
                  
        }
    } 
    
    //仕入テーブルに登録するメソッド
    public String registShiireData(){
        
        //仕入れ日を文字列で取得するためのグローバル変数
        String date = null;

        //データベースの日付登録のためのメソッド
        Timestamp timestamp =  new  Timestamp(System.currentTimeMillis());
        
        //プルダウンで決定した商品IDを文字列で取得
        syohinId = String.valueOf( syohinMstSb.getId().get(menuber -1));
        
        //仕入日を文字列データに型変換
        date = DateFormatUtil.parseDateToString(shiireDate);
         
System.out.println(date);
        
        //仕入データ登録のためにt_shiire_amountテーブルのEntityをオブジェクト生成し、コンストラクに代入
        TShiireAmount tShiireAmount = new TShiireAmount(date, syohinId, nyukaNum,timestamp, userDataUtil.sessionUserName());
        
        try {
            //仕入データをデータベースに登録する
            shiireDateSb.create(tShiireAmount);
        } catch (Exception e) {
            //エラーの際はコンソール上にエラーメッセージ表示
            e.printStackTrace();
        } 
        return null;
    }  
    //以下アクセサーメソッド
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
    public Date getShiireDate() {
        return shiireDate;
    }
    /**
     * 
     * @param shiireDate 
     */
    public void setShiireDate(Date shiireDate) {
        this.shiireDate = shiireDate;
    }
    /**
     * 
     * @return 
     */
    public Integer getNyukaNum() {
        return nyukaNum;
    }
    /**
     * 
     * @param nyukaNum 
     */
    public void setNyukaNum(Integer nyukaNum) {
        this.nyukaNum = nyukaNum;
    }
    /**
     * 
     * @return 
     */
    public Integer getMenuber() {
        return menuber;
    }
    /**
     * 
     * @param menuber 
     */
    public void setMenuber(Integer menuber) {
        this.menuber = menuber;
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
    
    
    
}
