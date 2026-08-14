class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int l=players.length;
        int n=trainers.length;
        int j=0;
        for(int i=0;i<n;i++){
            if(j==l) return j;
            if(players[j]<=trainers[i]){
                j++;
            }
        }
        return j;
    }
}