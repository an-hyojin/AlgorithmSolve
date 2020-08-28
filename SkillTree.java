import java.util.HashMap;
import java.util.HashSet;

public class SkillTree {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<skill.length(); i++){
            set.add(skill.charAt(i));
        }
        int size = skill.length();

        for(String s: skill_trees){
            int index = 0;
            char sk = skill.charAt(index);

            for(int i=0; i < s.length(); i++){
                if(set.contains(s.charAt(i))){
                    if(s.charAt(i)!=sk) break;

                    index++;
                    if(index>=size||i==s.length()-1){
                        answer++;
                        break;
                    }
                    sk = skill.charAt(index);
                }

            }
        }
        return answer;
    }

}
