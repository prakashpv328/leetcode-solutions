class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        HashMap<String,Integer> map=new HashMap<>();
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }
                else{
                    ds.union(i,map.get(mail));
                }
            }
        }

        List<List<String>> mails=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            mails.add(new ArrayList<>());
        }

        for(Map.Entry<String,Integer> m:map.entrySet()){
            String str=m.getKey();
            int node=ds.find(m.getValue());
            mails.get(node).add(str);
        }
        // System.out.print(mails);

        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mails.get(i).size()==0) continue;
            Collections.sort(mails.get(i));
            List<String> list=new ArrayList<>();
            list.add(accounts.get(i).get(0));
            for(String st:mails.get(i)){
                list.add(st);
            }
            ans.add(list);
        }

        // System.out.print(map);
        return ans;

    }
}

class DisjointSet{
    int []parent;
    int []rank;
    DisjointSet(int n){
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    int find(int u){
        if(parent[u]==u){
            return u;
        }
        return find(parent[u]);
    }

    void union(int u,int v){
        int pu=find(u);
        int pv=find(v);

        if(rank[pu]>rank[pv]){
            parent[pv]=pu;
        }
        else if(rank[pv]>rank[pu]){
            parent[pu]=pv;
        }
        else{
            parent[pu]=pv;
            rank[pu]++;
        }
    }
}