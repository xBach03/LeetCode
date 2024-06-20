public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0 || n == 0) return;
        int ptr1 = 0;
        int ptr2 = 0;
        int[] result = new int[m + n];
        int i = 0;
        while(m > 0 && n > 0) {
            if(nums1[ptr1] <= nums2[ptr2]) {
                result[i] = nums1[ptr1++];
                m--;
            } else {
                result[i] = nums2[ptr2++];
                n--;
            }
            i++;
        }
        int remainder = m == 0 ? n : m;
        if(remainder == m) {
            while(m-- > 0) {
                result[i++] = nums1[ptr1++];
            }
        } else {
            while(n-- > 0) {
                result[i++] = nums2[ptr2++];
            }
        }
        for(int j = 0; j < result.length; j++) {
            nums1[j] = result[j];
        }
    }
    public static void main(String[] Args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
