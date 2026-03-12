class DisjointSet {
    int n;
    int[] size , parent;

    public DisjointSet(int n) {
        this.n = n;
        this.size = new int[n];
        this.parent = new int[n];
        for(int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findUPar(int node) {
        if(parent[node] == node) return node;
        return parent[node] = findUPar(parent[node]);
    }

    public void UnionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(size[ulp_u] >= size[ulp_v]) {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        } else {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
    }
}

class Solution {
    //Question -> find max of min 
    public int maxStability(int n, int[][] edges, int k) {
        int must = 0;
        int maxPossible = Integer.MAX_VALUE;
        DisjointSet ds = new DisjointSet(n);
        for(int[] e : edges){
            if(e[3] == 1 ){
                must++;
                int u = e[0] , v = e[1];
                if(ds.findUPar(u) == ds.findUPar(v)) return -1;
                ds.UnionBySize(e[0] , e[1]);
                maxPossible = Math.min(maxPossible , e[2]);
            }
        }
        if(must > n-1) return -1;
        if(must == n-1) return maxPossible;
        int low = 1 , high = maxPossible;
        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canCreateTree( n , edges , mid , k)){
                ans = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
    }
    
    boolean canCreateTree(int n,int[][] edges,int threshold , int k){
        DisjointSet ds = new DisjointSet(n);
        int addedcnt = 0;
        //add all must edges
        for(int[] e : edges){
            if(e[3] == 1){
                int u = e[0] , v = e[1];
                addedcnt++;
                ds.UnionBySize(u,v);
                
            }
        }
        for(int[] e : edges){
            if(e[3] == 0 && e[2] >= threshold){
                int u = e[0] , v = e[1];
                if(ds.findUPar(u) != ds.findUPar(v)){
                    addedcnt++;
                    ds.UnionBySize(u,v);
                }
            }
        }

        //add non must edges  with Upgrade that connects 2 components
        for(int[] e : edges){
            if(k == 0) break;
            if(e[3] == 0 && e[2] < threshold && 2*e[2] >= threshold){
                int u = e[0] , v = e[1];
                if(ds.findUPar(u) != ds.findUPar(v)){
                    ds.UnionBySize(u,v);
                    addedcnt++;
                    k--;
                }
            }
        }
        return addedcnt == n-1;
    }
}