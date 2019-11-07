package fw;

import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *　ユーザーデータを取得しデータを渡すためのクラス
 * @author RieMatsui
 */
@Stateless 
public class UserDataUtil {
    
   public String sessionUserName(){
        String name = null;
        
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        final ExternalContext externalContext = facesContext.getExternalContext();
        final HttpSession session = (HttpSession) externalContext.getSession(false);
        
        name = (String) session.getAttribute("sessionKey");
        
        return name;
    }
    
}
