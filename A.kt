import java.util.*
 
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    repeat(t) {
        val n = sc.nextInt()
        val a = IntArray(n)
        val freq = mutableMapOf<Int, Int>()
        for (i in 0 until n) {
            a[i] = sc.nextInt()
            freq[a[i]] = freq.getOrDefault(a[i], 0) + 1
        }
        val uniqueNum = freq.entries.find { it.value == 1 }?.key
        println(a.indexOf(uniqueNum!!) + 1)
    }
}