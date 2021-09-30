import java.util.HashMap;

class Solution {
    
    static HashMap<String, Integer> enrollIdxs;
    static int[] profit;

   public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        enrollIdxs = new HashMap<>();
        profit = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) enrollIdxs.put(enroll[i], i);

        for (int i = 0; i < seller.length; i++) {
            int income = amount[i] * 100;
            int portion =0;
            String name = seller[i];

            while(income>=1){
                int eIdx = enrollIdxs.get(name);
                portion = (int) (income * 0.1);
                profit[eIdx] += income - portion;
                if (!referral[eIdx].equals("-")) {
                    name = referral[eIdx];
                    income = portion;
                }
                else break;

            }
        }

        int[] answer = new int[profit.length];
        for (int i = 0; i < profit.length; i++) answer[i] = profit[i];

        return answer;
    }
}
