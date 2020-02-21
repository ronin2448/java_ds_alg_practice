package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Create all possible permutations using backtracking 
 */
public class Permutations {

    List<List<Integer>> out = new LinkedList();
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curSelection = new LinkedList();
        List<Integer> choices = Arrays.stream(nums).boxed().collect(Collectors.toList());
        permuteArray(curSelection, choices);
        return this.out;
    }
    
    public void permuteArray(List<Integer> currentSelection, List<Integer> possibleChoices)
    {
//    	System.out.println(currentSelection);
        if(possibleChoices.size() == 0)
        {
            out.add( (currentSelection) );
            return;
        } else {
            for(int i = 0; i < possibleChoices.size(); i++)
            {
                List<Integer> cur = new LinkedList<Integer>(currentSelection);
                int nextSelection = possibleChoices.get(i);
                cur.add(nextSelection);
                List<Integer> remainingChoices = new LinkedList<Integer>(possibleChoices);
                remainingChoices.remove(i);
                this.permuteArray(cur, remainingChoices);                
            }
        }
    }	
	public static void main(String[] args) {
		Permutations p = new Permutations();
		int [] nums = new int[3];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 3;
		p.permute(nums);
		System.out.println(p.out);

	}

}
