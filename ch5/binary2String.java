package ch5;

/**
 * Created by lipingxiong on 10/7/15.
 * 5.2
 */
public class binary2String {
    String binary2String9(double num){
        if(num>1 || num<=0) return "ERROR";
        StringBuilder bs = new StringBuilder();
        bs.append(".");
        while(num>0){
            if(bs.length() >=32){
                return "ERROR";
            }
            double r = num * 2;
            if(r>=1){
                bs.append(1);
                num = r-1;
            }
            else{
                bs.append(0);
                num = r;
            }
        }
        return bs.toString();
    }

}
