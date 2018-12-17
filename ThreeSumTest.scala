import scala.collection.mutable.ArrayBuffer

object Solution {
    def threeSum(nums: Array[Int]) : List[List[Int]] = {
        val len = nums.length
        var outputList : ArrayBuffer[List[Int]] = ArrayBuffer()
        var result = List[List[Int]]()
        if(len < 3) {result}
        else{
        var arr : ArrayBuffer[Int] = ArrayBuffer()
        for(a <- 0 until len){
            for(b<-a+1 until len){
                for(c <- b+1 until len){
                    arr.append(nums(a),nums(b),nums(c))
                    if(sumCheck(arr)){
                        outputList.append(arr.toList)
                    }
                    arr = ArrayBuffer()
                    
                }
            }
        }
        val outputList1 = duplicateCheck(outputList.toList)
        outputList1
        }
    }
    
    def sumCheck(arr : ArrayBuffer[Int]) : Boolean = {
        if (arr.sum ==0) true
        else false
    }
    
    def duplicateCheck(inParam : List[List[Int]]) : List[List[Int]] = {
      val len = inParam.length
      val finalList : ArrayBuffer[List[Int]] = ArrayBuffer(List())
      for(a <- 0 until len){
        finalList.append(inParam(a).sorted)
      }
      return finalList.distinct.toList.slice(1,finalList.length)
    }
}
