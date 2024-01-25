class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int ans[]=new int[2];
        boolean check[]=new boolean[100001];
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(check[arr[i]]==true){
                ans[0]=arr[i];
            }
            check[arr[i]]=true;
            max=Math.max(max,arr[i]);
        }
        for(int i=1;i<=max+1;i++)
        {
            if(check[i]==false){
                ans[1]=i;
                break;
            }
        }
        return ans;
    }
}