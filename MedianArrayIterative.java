class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int Total = nums1.length+nums2.length;
        int avg = Total/2;
        int i=0,j=0, count=0;
        double val1=0;
        double val2=0;
        
        while(count<=avg && i<nums1.length && j<nums2.length){
            if(i<nums1.length && nums1[i]<=nums2[j]){
                val2=val1;
                val1=nums1[i];
                i++;
                count++;
            }else{
                if(j<nums2.length){
                val2=val1;
                val1=nums2[j];
                 if(j<=nums2.length-1){
                j++;}
                count++;
            }
            }
        }
        
        while(i<nums1.length && count<=avg){
                val2=val1;
                val1=nums1[i];
                i++;
                count++;
            }
        
         while(j<nums2.length && count<=avg){
                val2=val1;
                val1=nums2[j];
                j++;
                count++;
            }
        
        double median =0;
        if(Total%2==0){
            System.out.println(val1);
            System.out.println(val2);
            median = (val1+val2)/2;
        }else{
            median = val1;
        }
        return median;
}}
