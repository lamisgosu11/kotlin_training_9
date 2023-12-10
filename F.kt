import java.util.*
 
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val weights = IntArray(n)
    for (i in 0 until n) {
        weights[i] = scanner.nextInt()
    }
    weights.sort()
    var lastWeight = 0
    var count = 0
    for (weight in weights) {
        if (lastWeight < weight - 1) {
            lastWeight = weight - 1
            count++
        } else if (lastWeight < weight) {
            lastWeight = weight
            count++
        } else if (lastWeight < weight + 1) {
            lastWeight = weight + 1
            count++
        }
    }
    println(count)
}