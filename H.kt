import java.util.*
 
const val MAX_VAL = 200001
const val MIN_VAL = -200001
 
fun main() {
    val scanner = Scanner(System.`in`)
 
    val n = scanner.nextInt()
 
    val a = IntArray(n)
 
    for (i in 0 until n)
        a[i] = scanner.nextInt()
 
    val memo = Array(2) { IntArray(n) }
    val prevType = Array(2) { ShortArray(n) { -1 } }
 
    memo[0].fill(MAX_VAL)
    memo[1].fill(MIN_VAL)
 
    memo[0][0] = MIN_VAL
    memo[1][0] = MAX_VAL
 
    for (i in 1 until n) {
        if (a[i - 1] < a[i] && memo[1][i] < memo[1][i - 1]) {
            prevType[0][i] = 0
            memo[1][i] = memo[1][i - 1]
        }
 
        if (a[i] < memo[1][i - 1] && a[i - 1] < memo[0][i]) {
            prevType[1][i] = 0
            memo[0][i] = a[i - 1]
        }
 
        if (a[i] < a[i - 1] && memo[0][i - 1] < memo[0][i]) {
            prevType[1][i] = 1
            memo[0][i] = memo[0][i - 1]
        }
 
        if (memo[0][i - 1] < a[i] && memo[1][i] < a[i - 1]) {
            prevType[0][i] = 1
            memo[1][i] = a[i - 1]
        }
    }
 
    var currentSequence: Short = -1
 
    if (memo[0][n - 1] != MAX_VAL)
        currentSequence = 1
    else if (memo[1][n - 1] != MIN_VAL)
        currentSequence = 0
 
    var ansS = "NO"
    val ans = ShortArray(n)
 
    if (currentSequence.toInt() != -1) {
        ansS = "YES"
 
        for (i in n - 1 downTo 0) {
            ans[i] = currentSequence
            currentSequence = prevType[currentSequence.toInt()][i]
        }
    }
 
    println(ansS)
 
    if (ansS[0] == 'Y') {
        for (i in 0 until n)
            print("${if (i > 0) " " else ""}${ans[i]}")
 
        println()
    }
}