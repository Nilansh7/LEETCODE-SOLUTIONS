class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>cur=new ArrayList<>();
        helper(root,targetSum,ans,cur);
        return ans;
    }
    public void helper(TreeNode root,int target,List<List<Integer>>ans,List<Integer>cur){
        if(root==null)return;
        cur.add(root.val);
        if(root.left==null&&root.right==null){
            if(root.val==target){
                ans.add(new ArrayList<>(cur));
            }
        }else{
            helper(root.left,target-root.val,ans,cur);
            helper(root.right,target-root.val,ans,cur);
        }
        cur.remove(cur.size()-1);      
    }
}