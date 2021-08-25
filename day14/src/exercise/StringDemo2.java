package exercise;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-24 16:47
 */
public class StringDemo2 {
    //找子串问题
    public String getMaxSubString1(String str1, String str2) {
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
        int minlenth = minStr.length();
        for (int i = 0; i < minStr.length(); i++) {
            for (int x = 0, y = minlenth - i; y <= minlenth; x++, y++) {
                String subStr = minStr.substring(x, y);
                if (maxStr.contains(subStr)) {
                    return subStr;
                }
            }
        }
        return null;
    }

    public String[] getMaxSubString2(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxStr=(str1.length()>=str2.length())?str1:str2;
            String minStr=(str1.length()<str2.length())?str1:str2;
            StringBuffer sBuffer=new StringBuffer();
            for(int i=0;i<minStr.length();i++){
                for(int x=0,y=minStr.length()-i;y<=minStr.length();x++,y++){
                    String subStr=minStr.substring(x, y);
                    if(maxStr.contains(subStr)){
                        sBuffer.append(subStr+",");
                    }
                }
                if(sBuffer.length()!=0){
                    break;
                }
            }
            String[] split=sBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }
        return null;
    }

    @Test
    public void Test1() {
        String str1 = "adsfafqwrddfshqweaf";
        String str2 = "asdfsgefafsdf";
        System.out.println(getMaxSubString1(str1, str2));
        System.out.println(Arrays.toString(getMaxSubString2(str1, str2)));
    }
}
