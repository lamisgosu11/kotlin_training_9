import java.util.*
 
const val UNCOLORED = -1
 
fun toPosition(c: Char): Int {
    return c - 'a'
}
 
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val k = scanner.nextInt()
    val s = scanner.next()
    val t = scanner.next()
 
    val ans = IntArray(k + 1)
 
    for (i in k downTo 1) {
        ans[i] += toPosition(s[i - 1]) + toPosition(t[i - 1])
        ans[i - 1] += ans[i] / 26
        ans[i] %= 26
    }
 
    for (i in 0..k) {
        val res = ans[i] % 2
        ans[i] /= 2
 
        if (i < k)
            ans[i + 1] += 26 * res
    }
 
    for (i in 1 until k + 1) {
        print((ans[i] + 'a'.toInt()).toChar())
    }
}