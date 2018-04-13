class Solution {
   
 private final static String[] Single ={"","One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ","Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
 private final static String [] DoubleDigit={"","","Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
 private final static String [] Groups={"", "Thousand ", "Million ", "Billion "};
    
    public String numberToWords(int num) {
        String s="";
        if (num==0){
            return "Zero";
        }
       for(int i=0;i<Groups.length;i++){
           int groupNum = num%1000;
           if(groupNum>0){
               s= getString(groupNum) + Groups[i] + s;
           }
           num=num/1000;
       }
        return s.trim();
    }
    
    public String getString(int num){
        
        StringBuilder str = new StringBuilder();
        int hundreds = num/100;
        if(hundreds>0){
            str.append(Single[hundreds]+ "Hundred ");
            num=num%100;
        }
        int tens=num/10;
        if(tens>1){
             str.append(DoubleDigit[tens]);
            num=num%10;
        }
        return str.append(Single[num]).toString();
    }
}

