class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        List<Integer> list = new ArrayList<>();
        int j=0;
        for (i = nums.length-2; i >= 0; i--) {
            list.add(nums[i+1]);
            if (nums[i+1]>nums[i]) break;
        }
        if (i<0) {
            Arrays.sort(nums);
            return;
        }
        list.add(nums[i]);
        int[] array = list.stream().mapToInt(n -> n).toArray();
        Arrays.sort(array);
        for (j = array.length-1;j>=0;j--) if (array[j] == nums[i]) break;
        nums[i] = array[j+1];
        int k =0;
        for (int x=i+1;x<nums.length;x++) {
            nums[x]=array[k];
            k++;
            if (k==j+1) k++;
        }
        return;
    }
}
