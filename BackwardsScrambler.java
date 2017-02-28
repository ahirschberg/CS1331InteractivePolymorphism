public class BackwardsScrambler extends Scrambler {
    @Override
    public String scramble(String s) {
        String result = "";
        for (char c : s.toCharArray()) {
            result = c + result;
        }
        return result;
    }
}
