def solution(citations):
    h = max(citations)
    
    while(True) :
        m = len([c for c in citations if c >= h])
        
        if m >= h :
            break
        else :
            h -= 1
            
    return h