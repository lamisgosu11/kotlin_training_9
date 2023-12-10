import java.util.*
 
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val t = sc.next()
    var s = ""
    var i = 0
    while (i < n) {
        s += t[i]
        i += s.length
    }
    println(s)
}