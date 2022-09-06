package backtracking;

public class EnergyRequired {

    int min=Integer.MAX_VALUE;
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int solution(int[][] grid) {
        backTrack(grid, 0, 0, 0, 1);
        return min;
    }

    public void backTrack(int[][] grid, int x, int y, int currEnergy, int sum) {
        if(x==grid.length-1 && y== grid.length-1) {
            if(min>sum) {
                min = sum;
            }
            return ;
        }
        int ene = grid[x][y];
        currEnergy += ene;
        grid[x][y] = 0;
        for(int i=0; i<directions.length && currEnergy>0; i++) {
            int nextX = x+directions[i][0];
            int nextY = y+directions[i][1];
            if(isValid(nextX, nextY, grid.length, grid[0].length) && grid[nextX][nextY] != -1) {
                backTrack(grid, nextX, nextY, currEnergy-1, sum+1);
            }
        }
        grid[x][y] = ene;
    }

    private boolean isValid(int x, int y, int m, int n) {
        if(x<0 || y<0 || x>=m || y>=n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        EnergyRequired energyRequired = new EnergyRequired();
        System.out.println(energyRequired.solution(new int[][]{
                { 2, 0, 0, -1},
                { 0, 0, 2, -1},
                { 5, -1, 0, 0},
                { 0, -1, 10, 0}}));
    }
}
