class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        ArrayList<Character> list= new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)->Integer.compare(map.get(b),map.get(a)));
        StringBuilder result=new StringBuilder();
        for(char ch:list){
            for(int i=1;i<=map.get(ch);i++){
                result.append(ch);
            }
        }
        return result.toString();
    }
}