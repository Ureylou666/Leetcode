/**
     * @Description: 4. Median of Two Sorted Arrays
     * @Param: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
     * @return @return null
     * @author urey.lou
     * @create 2024/2/12
     **/

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combine = new int[ (nums1.length + nums2.length) / 2 + 1 ] ;
        int i = 0 ;
        int j = 0 ;
        int n = 0 ;
        do {
            if (i == nums1.length) {
                combine[n] = nums2[j];
                j++;
            } else {
                if (j == nums2.length) {
                    combine[n] = nums1[i];
                    i++;
                } else {
                    if (nums1[i] < nums2[j]) {
                        combine[n] = nums1[i];
                        i++;
                    } else {
                        combine[n] = nums2[j];
                        j++;
                    }
                }
            }
            n++;
        } while ( ( n < (nums1.length + nums2.length) / 2 + 1) );
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (double) (combine[(nums1.length + nums2.length) / 2 - 1] + combine[(nums1.length + nums2.length)/2]) /  2 ;
        } else {
            return (double) (combine[(nums1.length + nums2.length) / 2 ]);
        }
    }
