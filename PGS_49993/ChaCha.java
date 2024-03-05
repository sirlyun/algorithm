import java.util.*;

class Solution {
    private List<Character> list;
    private int answer;
    
    public int solution(String skill, String[] skill_trees) {
        list = new LinkedList<>();
        for (int i = 0; i < skill.length(); i++) {
            list.add(skill.charAt(i));
        }

        // 검증
        for (int i = 0; i < skill_trees.length; i++) {
            if (validate(skill_trees[i])) {
                answer += 1;
            }
        }

        return answer;
    }

    private boolean validate(String input) {
        // input의 글자를 돌면서
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);

            // 해당 글자를 찾자.
            for (int j = 0; j < list.size(); j++) {
                // 찾았는데
                if (list.get(j) == target) {
                    Character thatSkill = list.get(j);

                    int temp = j;

                    // 전 스킬이 있으면 반복
                    while (temp > 0) {
                        thatSkill = list.get(temp - 1);

                        // 지금까지 지나온 글자들
                        String str = input.substring(0, i);

                        // 그 앞에 해당 글자가 없으면
                        if (!str.contains(String.valueOf(thatSkill))) {
                            return false;
                        }

                        temp -= 1;
                    }
                }

                // 못 찾았으면 ok
            }
        }

        // 모든 것을 통과하면
        return true;
    }
}
