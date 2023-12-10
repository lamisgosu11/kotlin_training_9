import java.util.*
 
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = sc.nextInt()
    }
    a.sort()
    var problems = 0
    for (i in 0 until n step 2) {
        problems += a[i + 1] - a[i]
    }
    println(problems)
}