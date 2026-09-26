class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n=s.length();
        int m=knowledge.size();
        StringBuilder result=new StringBuilder();
        HashMap<String,String> map=new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                int j=i+1;
                while(s.charAt(j)!=')'){
                    j++;
                }
                String key=s.substring(i+1,j);
                if(map.containsKey(key)){
                    result.append(map.get(key));
                }
                else{
                    result.append('?');
                }
                // for(int k=0;k<m;k++){
                //     if(key.equals(knowledge.get(k).get(0))){
                //         value=knowledge.get(k).get(1);
                //     }
                // }
                i=j;
            }
            else{
                result.append(ch);
            }
        }
        return result.toString();
    }
}