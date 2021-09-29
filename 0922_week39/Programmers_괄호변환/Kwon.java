class Kwon {
    public String solution(String p) {
        // 1.
        if(isEmpty(p))
            return p;
        
        // 2.
        String[] uv = split(p);
        String u = uv[0];
        String v = uv[1];
        
        // 3.
        if(valid(u))
            return u + solution(v);
        else{
            StringBuilder ret = new StringBuilder();
            ret.append('(').append(solution(v)).append(')');
            
            for(int i = 1; i < u.length() - 1; i++){
                if(u.charAt(i) == '(')
                    ret.append(')');
                else
                    ret.append('(');
            }
            
            return ret.toString();
        }
    }
    
    public boolean isEmpty(String p){
        return "".equals(p);
    }
    
    public String[] split(String w){
        int balance = 0;
        int index = 0;
        
        for(int i = 0; i < w.length(); i++){
            if(w.charAt(i) == '(')
                balance++;
            else
                balance--;
            
            if(balance == 0){
                index = i;
                break;
            }
        }
        
        String u = w.substring(0, index + 1);
        String v = w.substring(index + 1, w.length());
        
        return new String[]{u, v};
    }
    
    public boolean valid(String u){
        int stk = 0;
        
        for(int i = 0; i < u.length(); i++){
            if(u.charAt(i) == '(')
                stk++;
            else{
                if(stk == 0)
                    return false;
                else 
                    stk--;
            }
        }
        
        return stk == 0;
    }
}