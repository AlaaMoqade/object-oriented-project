package Views;

public class klkl {
	public static void main(String[] args) {
		int[] list = {-1,0,3,5,9,12};
		int taret = 9;
		int r = search(list, taret);
		if (r == -1)
			System.out.println(taret + "  does not exist in nums so return -1");
		else
			System.out.println(taret + " exists in nums and its index is " + r);
	}

	public static int search(int[] nums, int target) {
		int j = 0;
		for (int  i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				 j = i;
		}
		if(target == nums[j] )
			return j;
		else
			return -1;
	}
}
