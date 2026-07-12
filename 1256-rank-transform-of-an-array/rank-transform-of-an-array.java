class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int[] arr2 = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr2);

        int rank=1;
        HashMap<Integer,Integer> temp = new HashMap<>();
        for(int ele:arr2){
            if(!temp.containsKey(ele)){
                temp.put(ele,rank++);
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=temp.get(arr[i]);
        }
        return arr;
        
    }
}