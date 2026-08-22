class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int val=image[sr][sc];
        if(val==color) return image;

        dfs(image,sr,sc,val,color);
        return image;
    }

    void dfs(int [][]image,int i,int j,int val,int color){
        int m=image.length,n=image[0].length;

        if(i<0 || i>=m || j<0 || j>=n) return;
        if(image[i][j]!=val) return;
        image[i][j]=color;

        dfs(image,i+1,j,val,color);
        dfs(image,i-1,j,val,color);
        dfs(image,i,j+1,val,color);
        dfs(image,i,j-1,val,color);
    }
}