class Solution {
    class TrieNode{
        TrieNode[] children=new TrieNode[2];
    }
    TrieNode root=new TrieNode();
    void insert(int num){
        TrieNode temp=root;
        for(int i=30;i>=0;i--){
            int bit=(num>>i)&1;
            if(temp.children[bit]==null){
                temp.children[bit]=new TrieNode();
            }
            temp=temp.children[bit];
        }
    }
    int maxXor(int num){
        TrieNode temp=root;
        int ans=0;
        for(int i=30;i>=0;i--){
            int bit=(num>>i)&1;
            int opposite=1-bit;
            if(temp.children[opposite]!=null){
                ans|=(1<<i);
                temp=temp.children[opposite];
            }
            else{
                temp=temp.children[bit];
            }
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        for(int i:nums){
            insert(i);
        }
        int max=0;
        for(int i:nums){
            max=Math.max(max,maxXor(i));
        }
        return max;
    }
}