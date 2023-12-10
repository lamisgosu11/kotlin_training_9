import java.util.*
 
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var n = sc.nextInt()
    var k = sc.nextInt()
    val powers = PriorityQueue<Int>(compareByDescending { it })
    for (i in 30 downTo 0) {
        while (n shr i and 1 == 1) {
            powers.add(1 shl i)
            n -= 1 shl i
        }
    }
    if (powers.size > k) {
        println("NO")
    } else {
        while (powers.size < k) {
            val maxPower = powers.poll()
            if (maxPower == 1) {
                println("NO")
                return
            }
            powers.add(maxPower / 2)
            powers.add(maxPower / 2)
        }
        if (powers.size > k) {
            println("NO")
        } else {
            println("YES")
            println(powers.joinToString(" "))
        }
    }
}