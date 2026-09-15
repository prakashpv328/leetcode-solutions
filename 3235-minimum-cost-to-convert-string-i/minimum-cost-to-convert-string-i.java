class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int dis[][]=new int[26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(dis[i],10000001);
            dis[i][i]=0;
        }
        int l=original.length;
        for(int i=0;i<l;i++){
            int u=original[i]-'a';
            int v=changed[i]-'a';
            dis[u][v]=Math.min(cost[i],dis[u][v]);
        }

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(dis[i][k]==10000001 || dis[k][j]==10000001) continue;
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }
        int len=source.length();
        long res=0;
        for(int i=0;i<len;i++){
            if(dis[source.charAt(i)-'a'][target.charAt(i)-'a']==10000001){
                return -1;
            }
            res+=dis[source.charAt(i)-'a'][target.charAt(i)-'a'];
        }
        // System.out.print(Arrays.deepToString(dis));
        return res;
    }
}