class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] lastOcc = new int[26];
        
        for(int i=0;i<n;i++){
            lastOcc[s.charAt(i)-'a']=i;
        }
        
        Deque<Character> q = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(visited[ch-'a']==true) continue;
            while(q.size()>0 && q.getLast() > ch && lastOcc[q.getLast()-'a']>i){
                visited[q.removeLast()-'a'] = false;
            }
            
            q.addLast(ch);
            visited[ch-'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder("");
        while(q.size()>0) sb.append(q.removeFirst());
        
        return sb.toString();
    }
}