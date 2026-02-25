class Solution {
    private int getBits(int num, int count) {
        return num == 0 ? count : getBits(num >> 1, count + (num & 1));
    }

    public int[] sortByBits(int[] arr) {
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) temp[i] = arr[i];

        Arrays.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int bits = getBits(a, 0) - getBits(b, 0);
                return bits == 0 ? a - b : bits;
            }
        });

        for (int i = 0; i < arr.length; i++) arr[i] = temp[i];
        return arr;
    }
}