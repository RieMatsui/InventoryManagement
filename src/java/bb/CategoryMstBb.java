package bb;
/**
 * @author RieMatsui
 * @since 2017/03/10
 * @virsion 01
 * 
 */

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import ejb.CategoryMsSb;
import entity.TCategoryMaster;
import fw.UserDataUtil;
import java.sql.Timestamp;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;


@Named
@RequestScoped
public class CategoryMstBb {
    //分類マスターのセッションビーンクラス
    @EJB
    CategoryMsSb categoryMstSb;
    
    //ユーザ名のデータを取得するクラス
    @EJB
    UserDataUtil userDataUtil;

    //メンバ変数『分類ID』
    private String categoryId;
    //メンバ変数『分類名』
    private String categoryName;
    /**
     *　分類マスタに登録するクラス     
     */
    public void createCategoryMst(){
        
        //現在の時刻を登録するためにTimstampを変数としてセット
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
       //t_category_masterのテーブルをオブジェクト生成しコンストラクタに値を設定
       TCategoryMaster categoryMaster = new TCategoryMaster(categoryId, categoryName,timestamp, userDataUtil.sessionUserName());
       
        try {
            //EJBクラスのデータベース新規登録メソッドを呼び出し
            categoryMstSb.create(categoryMaster);
        } catch (Exception e) {
            //エラー発生時にエラーをコンソール上に表示
            e.printStackTrace();
        }
      
    }
    
    //以下アクセサーメソッド
    /**
     * 
     * @return 
     */
    public String getCategoryId() {
        return categoryId;
    }
    /**
     * 
     * @param categoryId 
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    /**
     * 
     * @return 
     */
    public String getCategoryName() {
        return categoryName;
    }
    /**
     * 
     * @param categoryName 
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
   
}
