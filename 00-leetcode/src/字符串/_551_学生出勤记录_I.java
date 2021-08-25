package 字符串;

/**
 * https://leetcode-cn.com/problems/student-attendance-record-i/
 */
public class _551_学生出勤记录_I {
    public boolean checkRecord(String s) {
        char[] cs = s.toCharArray();
        if (cs.length < 2) return true;

        int ac = 0, lc = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'A') {
                if (++ac == 2) return false;
                lc = 0;
            } else if (cs[i] == 'L') {
                if (++lc == 3) return false;
            } else {
                lc = 0;
            }
        }
        return true;
    }
}
