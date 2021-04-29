package 数学;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 * https://leetcode-cn.com/problems/excel-sheet-column-title/solution/guan-yu-n-de-li-jie-by-douya0808/
 */
public class _168_Excel表列名称 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int i = columnNumber % 26;
            sb.append((char) ('A' + i));

            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
