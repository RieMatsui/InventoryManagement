package fw;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 仕入データ入力、売上データ入力の仕入日、売上日の文字列データの
 * フォーマットを行うクラス
 * @author RieMastui
 * @since 2017/03/16
 * @version 1.0
 */
public class DateFormatUtil {
    
    //正規表現をメンバ変数で定義
    static public final String DATE_PATTERN = "yyyy/MM/dd";
    
    //文字列データを既定のフォーマットに変換するメソッド
    /**
     * 
     * @param  data 
     * @return 文字列データ str
     */
    public static String parseDateToString(Date data){
        String str;
        //引数の値がnullの時
        if (data == null) {
            //戻り値でnullを返す
            str = null;    
        }else{
            //それ以外はフォーマットして文字列を返す
            str = new SimpleDateFormat(DATE_PATTERN).format(data);
        }
            return str;
    }
    
}
