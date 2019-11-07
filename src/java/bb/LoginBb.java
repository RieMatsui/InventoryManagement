
package bb;



import ejb.LoginSb;
import entity.TUser;
import fw.FacesUtils;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;


/**
 * ログイン画面のバッキングビーン
 * @author WITC_RieMastui
 * @Since 20170317
 * @virsion 1.0
 * 
 */
//注釈　WEBコンテナに紐づけられる　EL名　一対一の関連付け
@Named
@SessionScoped
public class LoginBb implements Serializable{
    //『ユーザID』
    @NotNull
    private String userId;
    //『ユーザーパスワード』
    @NotNull
    private String userPassword;
 
    //エラーメッセージ表示
    private String msg;
    
    //ユーザー名
    private String userName;
    
    //ログイン時にデータベースに接続するためのEJBクラス
    @EJB
    LoginSb loginSb;
    

    /**
     * 
     * @return 文字列型：画面推移を返すためのメソッド
     * パスワード認証を行うメソッド
     */
    public String next(){  
        //主キーを引数として渡し、検索を行う
        TUser tUser = loginSb.find(userId);
        //取得した項目がnullでなく、パスワードがあっていれば次の画面に移行する
        if (tUser != null && tUser.getUserPassword().equals(userPassword)) {
            //このクラスのユーザ名にテーブルから取得したデータをセットする
            this.userName = tUser.getCreateUser();
            
            //faces-config.xmlファイルで画面推移を制御            
            //成功したときにメニュー画面に移動
            
            final FacesContext facesContext = FacesContext.getCurrentInstance();
            final ExternalContext externalContext = facesContext.getExternalContext();
            final HttpSession session = (HttpSession) externalContext.getSession(false);
            
            session.setAttribute("sessionKey", this.userName);
//            session.getAttribute("sessionKey");
                       
//            if (session != null) {
//                try {
//                session.invalidate();;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            }
                
         return "success";
        }else{
            //失敗したときエラーメッセージの表示
            FacesUtils.guidanceResult();
            //画面は元の画面を維持
           return "fail";
        }
    }
    
    public String logout(){
        
        final  FacesContext facesContext = FacesContext.getCurrentInstance();
        final ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.invalidateSession();
        
        return "login.xhtml";
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
    public String getUserPassword() {
        return userPassword;
    }
    /**
     * 
     * @param userPassword 
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    } 
    /**
     * 
     * @return 
     */
    public String getMsg() {
        return msg;
    }
    /**
     * 
     * @param msg 
     */
    public void setMsg(String msg) {
        this.msg = msg;
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
     * @param UserName 
     */
    public void setUserName(String UserName) {
        this.userName = UserName;
    }
       
}
