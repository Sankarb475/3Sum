object ThreeSumFinal {
    def threeSum(nums: Array[Int]): List[List[Int]] = {    
        val N = nums.sorted
        var result = List[List[Int]]()
        
        for (idx <- 0 until N.length 
             if N(idx) <= 0 
             if idx == 0 || N(idx) != N(idx-1)
        ){
          var (l,r) = (idx+1, N.length-1)           
            
          while (l < r){
            N(l) + N(idx) + N(r) match {
              case sum if sum > 0 => r -= 1
              case sum if sum < 0 => l += 1
              case 0 =>
                result = result :+ List(N(l), N(idx), N(r))
                do l += 1 while (l < r && N(l) == N(l-1))
                do r -= 1 while (l < r && N(r) == N(r+1))  
            }  
          } 
        }
        result
    }
}
