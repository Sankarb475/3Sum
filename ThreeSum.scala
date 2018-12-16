import scala.collection.mutable.ArrayBuffer

object ThreeSum {
    def threeSum(nums: Array[Int]): List[List[Int]] = {
        val len = nums.length
        if(len < 3) return List(nums.toList)
        var arr : ArrayBuffer[Int] = ArrayBuffer()
        var outputList : ArrayBuffer[List[Int]] = ArrayBuffer()
        for(a <- 0 until len){
            for(b<-a+1 until len){
                for(c <- b+1 until len){
                    arr.append(nums(a),nums(b),nums(c))
                    //println(arr)
                    var arrPart : ArrayBuffer[Int] = arr
                    if(sumCheck(arrPart)){
                        outputList.append(arrPart.toList)
                        arr = ArrayBuffer()
                    }
                    else{
                      arr = ArrayBuffer()
                    }
                }
            }
        }
        val outputList1 = duplicateCheck(outputList.toList)
        return outputList1
    }
    
    def sumCheck(arr : ArrayBuffer[Int]) : Boolean = {
        if (arr.sum ==0) true
        else false
    }
    
    def duplicateCheck(inParam : List[List[Int]]) : List[List[Int]] = {
      val len = inParam.length
      //println(inParam)
      val finalList : ArrayBuffer[List[Int]] = ArrayBuffer(List())
      for(a <- 0 until len){
        finalList.append(inParam(a).sorted)
      }
      //println(finalList)
      return finalList.distinct.toList.slice(1,finalList.length)
    }
}
