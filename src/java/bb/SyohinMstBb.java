
package bb;


import ejb.SyohinMstSb;
import entity.TCategoryMaster;
import entity.TSyohinMaster;
import fw.DateFormatUtil;
import fw.UserDataUtil;
import java.sql.Timestamp;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import report.DetailsData;
import report.HeaderData;
import report.ReportData;
import org.apache.poi.ss.usermodel.Workbook;



/**
 *
 * @author RieMatsui
 * @since 2017/03/15
 * @version 1.0
 */
@Named
@RequestScoped
public class SyohinMstBb {
    
    //メンバ変数　『商品ID』
    private String syohinId;    
    
    //メンバ変数   『分類ID』
    private String categoryId;
    
    //メンバ変数　『商品名』
    private String syohinName;
    
    //メンバ変数　『仕入金額』
    private Integer shiirekingaku;
    
    //メンバ変数　『売上金額』
    private Integer uriagekingaku;
    
    //メンバ変数　『ユーザー名』
    private String userName;
    
    
    //所品マスタクラス
    @EJB
    SyohinMstSb syohinMstSb;
    
    //ユーザ名のデータを取得するクラス
    @EJB
    UserDataUtil userDataUtil;
    
    @EJB
    DateFormatUtil dateFormatUtil;
    
    @Inject
    
    
   
    //商品マスタを新規登録するためのメソッド
    public String createSyohinMstData(){
        
        //登録日時を生成
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        //関連する分類テーブルをオブジェクト生成しコンストラクに分類IDを代入
        TCategoryMaster tCategoryMaster = new TCategoryMaster(categoryId);
        //商品マスタデーブルをオブジェクト生成しコンストラクタに値を代入

//TODO   本来はログインしているユーザをCREATE_USERに登録する     
        TSyohinMaster tSyohinMaster = new TSyohinMaster(syohinId, tCategoryMaster, syohinName, shiirekingaku, uriagekingaku, timestamp,userDataUtil.sessionUserName()); 
  
        try {
            //商品マスタにデータを登録するためのセッションビーンクラスのメソッド
            syohinMstSb.create(tSyohinMaster);
        } catch (Exception e) {
            //エラーがあればログに書き出す
            e.printStackTrace();
        }
        //今現在の画面を表示する
        return null;
    }
    
    public String outputExecelFile(){
        
        
        return null;
    }
    
    public  ReportData setData() {
                
                //日付(文字列データ)
                String date = null;
                
                //作成日を取得
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                
                //作成日をDate型から文字列tに変換
                date = DateFormatUtil.parseDateToString(timestamp);
                
                //作成ファイルの文字を運ぶためのオブジェクト生成
		ReportData dataContainer = new ReportData();
                
		HeaderData header = new HeaderData();
		Map<String, String> dataMap = header.getDataMap();

		DetailsData details = new DetailsData();
                
                
		Map<String, Object[]> dataListMap = details.getDataListMap();

                        //ヘッダー部分
			header.setReportName("商品マスタ01");
                        
			dataMap.put("$DELIVERY_NO", "01000001");
			dataMap.put("$POST_CODE", "111-1111");
			dataMap.put("$ADDRESS1", "東京都AA区AAA5-6-78");
			dataMap.put("$ADDRESS2", "AAAAAビルディング11階");
			dataMap.put("$CUSTOMER_NAME", "(株)WITC");
			dataMap.put("$CREATE_DATE", date);
			dataMap.put("$CREATE_NAME", userDataUtil.sessionUserName());
                        
//　　************ 後で変更　＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊
                      
			dataMap.put("$S_TOTAL_SALES", "1,300,000");
			dataMap.put("$S_AMOUNT", "65,000");
			dataMap.put("$S_TOTAL_SALES_WT", "1,365,000");
                        dataMap.put("$T_TOTAL_SALES", "1,300,000");
			dataMap.put("$T_AMOUNT", "65,000");
			dataMap.put("$T_TOTAL_SALES_WT", "1,365,000");

//			dataListMap.put("$SYOHIN_ID[]", new String[] { "A0001", "B0002", "C0003", "D0004", "E0005" });
//			dataListMap.put("$CATEGORY_ID[]", new String[] { "アドバン・スマートフォンA", "アドバン・スマートフォンB", "アドバン・スマートフォンC",
//					"アドバン・スマートフォンD", "アドバン・スマートフォンE" });
//			dataListMap.put("$SYOHIN_NAME[]", new String[] { "5", "10", "15", "20", "25", });
//			dataListMap.put("$URIAGEKINGAKIU[]", new String[] { "12,000", "14,000", "16,000", "18,000", "20,000" });

//			details.setNumOfDetails(dataListMap.get("$SYOHIN_ID[]").length);


		dataContainer.setHeader(header);
		dataContainer.setDetails(details);
		return dataContainer;
        
    }
    
    //以下アクセサーメソッド
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
    public String getSyohinName() {
        return syohinName;
    }
    /**
     * 
     * @param syohinName 
     */
    public void setSyohinName(String syohinName) {
        this.syohinName = syohinName;
    }
    /**
     * 
     * @return 
     */
    public Integer getShiirekingaku() {
        return shiirekingaku;
    }
    /**
     * 
     * @param shiirekingaku 
     */
    public void setShiirekingaku(Integer shiirekingaku) {
        this.shiirekingaku = shiirekingaku;
    }
    /**
     * 
     * @return 
     */
    public Integer getUriagekingaku() {
        return uriagekingaku;
    }
    /**
     * 
     * @param uriagekingaku 
     */
    public void setUriagekingaku(Integer uriagekingaku) {
        this.uriagekingaku = uriagekingaku;
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
