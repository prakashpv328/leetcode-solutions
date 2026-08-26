class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
     List<List<Integer>> ans = new ArrayList<>();
     List<Integer> list = new ArrayList<>();
     combSum(0,list,target,candidates,ans);
     return ans;
   }

   public void combSum(int id,List<Integer> list,int target,int[] candidates,List<List<Integer>> ans)
   {
    if(id==candidates.length || target<=0){
        if(target==0)
            ans.add(new ArrayList<>(list));
        return;
    }

        list.add(candidates[id]);
        combSum(id+1,list,target-candidates[id],candidates,ans);
        list.remove(list.size()-1);

        while(id+1<candidates.length && candidates[id]==candidates[id+1])
            id++;

        combSum(id+1,list,target,candidates,ans);
    
   }
}