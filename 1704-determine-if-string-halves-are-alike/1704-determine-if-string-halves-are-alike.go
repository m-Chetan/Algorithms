func halvesAreAlike(s string) bool {
    s = strings.ToLower(s)
    n := len(s)
    i := 0
    count := 0
    for i<n {
        ch := s[i]
        if ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' {
            if(i<n/2){
                count++
            } else{
                count--
            }
        }
        i++
    }
    return count==0
}