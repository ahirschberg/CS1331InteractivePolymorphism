public class CipherScrambler extends Scrambler {
    @Override
    public String scramble(String s) {
        String result = "";
        for (char c : s.toCharArray()) {
            result += (c - 1);
        }
        return result;
    }
}
