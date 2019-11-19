class  findRedundantConnection {
    int MAX_EDGE_VAL = 1000;
    public int[] findRedundantConnection(int[][] edges) {
        //union find
        UF uf = new UF(MAX_EDGE_VAL+1);
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])) return edge;

        }
        throw new AssertionError();

    }
}

class UF{
    int[] parent;
    int[] rank;//height

    public UF(int size){
        parent = new int[size];
        for(int i = 0;i<size;i++) parent[i] =i;
        rank = new int[size];
    }

    public int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y){
        int px = find(x), py = find(y);
        if(px==py) return false;
        else if(rank[px]<rank[py]){
            rank[px]=py;
        }else if(rank[px]>rank[py]){
            rank[py]=px;
        }else{
            parent[py] = px;
            rank[px]++;
        }

        return true;
    }

}