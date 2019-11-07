package bb;

import ejb.SyohinMstSb;
import ejb.UriageDataSb;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import entity.TUriageAmount;
import fw.DateFormatUtil;
import fw.UserDataUtil;
import java.sql.Timestamp;

/**
 *
 * @author WITC_RieMatsui
 */
@Named
@RequestScoped
public class UriageData {
    
    //商品ID
    private String syohinId;
    //売上日
    @NotNull
    private Date uriageDate;
    //売上個数
    @NotNull
    private Integer uriageNum;
    //メニューバー
    private Integer menuber;
    
    //商品マスタのデータベースに接続するためのEJBクラス
    @EJB
    SyohinMstSb syohinMstSb;
    
    //売上データベースに登録するためのEJBクラス
    @EJB
    UriageDataSb uriageDateSb;
    
    //ユーザ名のデータを取得するクラス
    @EJB
    UserDataUtil userDataUtil;
    
    //メニューバーに商品名と商品IDを表示
    private static Map<String,Integer> syohinItems;
    
    //ページが読み込まれたときにデータベースに接続し読み込むためのメソッド
    @PostConstruct
    public void pc(){
        //商品名と商品IDをマップにセット
        syohinItems = new LinkedHashMap();
        //データ件数をデータベースから取得
        int num = (int)syohinMstSb.dataCount();
                for (int i = 1; i <= num ; i++){
                    //件数の数だけItemsを作成(登録されている商品IDと商品名を表示)
                    syohinItems.put(syohinMstSb.getId().get(i-1) + "\n" + syohinMstSb.getShohinName().get(i-1), i);
                  
        }
    } 
    /**
     * 
     * @return 
     */
    public String registUriageData(){
        
        //売上日を文字列データに変換するための文字列データ
        String date = null;
        //タイムスタンプをオブジェクト生成
        Timestamp timestamp =  new  Timestamp(System.currentTimeMillis());
        
        //選択したIndexからアイテムを取得し、商品IDを文字列データに変換
        syohinId = String.valueOf( syohinMstSb.getId().get(menuber -1));
        
        //取得した仕入日を文字列データに変換
        date = DateFormatUtil.parseDateToString(uriageDate);
        
        //
        
        //売上データデーブルをオブジェクト生成し、コンストラクタに代入
         TUriageAmount tUriageAmount = new TUriageAmount(date, syohinId, uriageNum, timestamp, userDataUtil.sessionUserName());
        try {
           //データベースに接続する
            uriageDateSb.create(tUriageAmount);
        } catch (Exception e) {
            //問題があればコンソールに表示
            e.printStackTrace();
        }
        //処理が完了した際に今の画面にとどまる
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
    public Date getUriageDate() {
        return uriageDate;
    }
    /**
     * 
     * @param uriageDate 
     */
    public void setUriageDate(Date uriageDate) {
        this.uriageDate = uriageDate;
    }
    /**
     * 
     * @return 
     */
    public Integer getUriageNum() {
        return uriageNum;
    }
    /**
     * 
     * @param uriageNum 
     */
    public void setUriageNum(Integer uriageNum) {
        this.uriageNum = uriageNum;
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
    
    
}
