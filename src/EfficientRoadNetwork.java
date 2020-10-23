public class EfficientRoadNetwork
{
    public boolean efficientRoadNetwork(int n, int[][] roads)
    {
        if(n==0 || roads.length==0)
            return false;
        boolean[][] adjMatrix=new boolean[n][n];
        for(int[] i:roads)
        {
            adjMatrix[i[0]][i[1]]=true;
            adjMatrix[i[1]][i[0]]=true;
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j && !adjMatrix[i][j])
                {
                    boolean found=false;
                    for(int k=0;k<n;k++)
                    {
                        if(k != i && k != j && adjMatrix[i][k] && adjMatrix[j][k])
                            found=true;
                    }
                    if(!found)
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        EfficientRoadNetwork obj=new EfficientRoadNetwork();
        System.out.println(obj.efficientRoadNetwork(6,new int[][]{{0,4},{5,0},{2,1},{1,4},{2,3},{5,2}}));
    }
}
