class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder result=new StringBuilder();
        HashMap<String,String> map=new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                int j=s.indexOf(')',i+1);
                String key=s.substring(i+1,j);
                if(map.containsKey(key)){
                    result.append(map.get(key));
                }
                else{
                    result.append('?');
                }
                i=j;
            }
            else{
                result.append(ch);
            }
        }
        return result.toString();
    }
}