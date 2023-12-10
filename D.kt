import java.util.*
 
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = sc.nextInt()
    }
    a.sort()
    val inc = mutableListOf<Int>()
    val dec = mutableListOf<Int>()
    for (i in 0 until n) {
        if (inc.isEmpty() || a[i] != inc.last()) {
            inc.add(a[i])
        } else if (dec.isEmpty() || a[i] != dec.last()) {
            dec.add(a[i])
        } else {
            println("NO")
            return
        }
    }
    println("YES")
    println(inc.size)
    println(inc.joinToString(" "))
    println(dec.size)
    dec.reverse()
    println(dec.joinToString(" "))
}
