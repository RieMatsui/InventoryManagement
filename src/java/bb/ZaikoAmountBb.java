package bb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author WITC_RieMastui
 * @since 2017/03/16
 * @version 1.0
 */
@Named
@RequestScoped
public class ZaikoAmountBb {
    
    //在庫数
    private Long zaikoNum;
    
    //在庫金額
    private Long zaikokingaku;
    
    
    public String outputData(){

    return null;
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
    public Long getZaikokingaku() {
        return zaikokingaku;
    }
    /**
     * 
     * @param zaikokingaku 
     */
    public void setZaikokingaku(Long zaikokingaku) {
        this.zaikokingaku = zaikokingaku;
    }
    
    

}
