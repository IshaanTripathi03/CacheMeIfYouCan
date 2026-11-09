class Solution {
    class TrieNode{
        TrieNode[] children=new TrieNode[2];
    }
    TrieNode root=new TrieNode();
    void insert(int num){
        TrieNode node=root;
        for(int i=30;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.children[bit]==null){
                node.children[bit]=new TrieNode();
            }
            node=node.children[bit];
        }
    }
    int maxXor(int num){
        TrieNode node=root;
        int ans=0;
        for(int i=30;i>=0;i--){
            int bit=(num>>i)&1;
            int opposite=1-bit;
            if(node.children[opposite]!=null){
                ans|=(1<<i);
                node=node.children[opposite];
            }
            else{
                node=node.children[bit];
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
            max=Math.max(max, maxXor(i) );
        }
        return max;
    }
}