
//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//Find the median of the two sorted arrays.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length ;
        if(total%2==0){
            return (helper(nums1, nums2, 0,0,total/2+1)+helper(nums1, nums2, 0,0,total/2))/2.0;
        }
        else
        {
            return helper(nums1, nums2, 0,0,total/2+1);
        }
    }
        
        public double helper(int[] nums1, int[] nums2, int s1, int s2, int k){
            
            if(s1>=nums1.length){
                return nums2[s2+k-1];
            }
            else if(s2>=nums2.length){
                return nums1[s1+k-1];
            }
            
            if(k==1){
                return Math.min(nums1[s1], nums2[s2]);
            }
            
            int m1 = s1+k/2-1;
            int m2 = s2+k/2-1;
            
            int mid1 = (m1<nums1.length)?nums1[m1]:Integer.MAX_VALUE;
            int mid2 = (m2<nums2.length)?nums2[m2]:Integer.MAX_VALUE;
            
            if(mid1<mid2){
                return helper(nums1, nums2, m1+1,s2,k-k/2 );
            }
            else
                return helper(nums1, nums2, s1,m2+1,k-k/2);
            
          
        }
}
