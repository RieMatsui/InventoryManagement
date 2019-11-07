
package fw;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author RieMatsui
 * 
 */
public class FacesUtils {
    
    
    /**
     * 
     * @return エラーメッセージ
     * エラーメッセージを表示するメソッド
     */
    public static String guidanceResult(){
        FacesMessage message = null;
        //Faces Contextを取得する
        FacesContext context = FacesContext.getCurrentInstance();
        
        //画面のUIコンポーネントを取得する
        UIComponent component = null;
        
        //画面のUIコンポーネントのクライアントIDを取得する
        String clientId = null;
        
        component = context.getViewRoot().findComponent("myForm:dealResult");
        clientId = component.getClientId(context);
        //メッセージ作成
        message = new  FacesMessage("ログインユーザーまたはパスワードが違います");
        //メッセージをＵＩコンポーネントに結びつける
        context.addMessage(clientId, message);
        //作成したエラーメッセージを返す
        return context.toString();
        
    }
}