
package bb;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author WITC_RieMatsui
 * @Since 20170310
 * 
 * メニュー画面のバッキングビーン
 */
@Named
@RequestScoped
public class MenuBb {
    
    //メンバ変数『ユーザID』
    private String userId;
    
    //メンバ変数『ユーザ名』
    private String userName;
    
    /**
     * 
     * @return 文字列：画面推移先
     * メニュー画面から商品マスタ画面に移動するメソッド
     */
    public String goSyohinMaster(){
       return "syohinMaster.xhtml";
    }
    /**
     * 
     * @return 文字列：画面推移先
     * メニュー画面からカテゴリマスタに移動するメソッド
     */
    public String goCategoryMaster(){
        return "categoryMaster.xhtml";
    }
    /**
     * 
     * @return 文字列：画面推移先
     * メニュー画面からカテゴリマスタに移動するためのメソッド
     */   
    public String goShiireDataInput() {
        return "shiireDataInput.xhtml";
    }
    /**
     * 
     * @return 文字列：画面推移先
     * メニュー画面から売上データ登録の画面に移動するためのメソッド
     * 
     */   
    public String goUriageDataInput(){
        return "uriageDataInput.xhtml";
    }
    /**
     * 
     * @return 文字列：画面推移先
     * メニュー画面から在庫数確認(個別)の画面に移動するためのメソッド
     */   
    public String goZaikoKobetu(){
        return "zaikoKobetsu.xhtml";
    }
    /**
     * 
     * @return 文字列：画面推移先
     *メニュー画面から在庫数確認(合計)の画面に移動するためのメソッド
     */   
    public String goZaikoAmount(){
        return "zaikoAmount.xhtml";
    }
    //以下アクセサーメソッド
    /**
     * 
     * @return 
     */
    public String getUserId() {
        return userId;
    }
    /**
     * 
     * @param userId 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**
     * 
     * @return 
     */
    public String getUserName() {
        return userName;
    }
    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}
