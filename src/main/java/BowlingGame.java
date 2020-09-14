import exception.IllegalInputException;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public int getScore(String testString) throws IllegalInputException {
        String[] splitString = testString.split(",");
        if (splitString.length < 10) {
            throw new IllegalInputException("numbers less than 10");
        }
        List<Integer> pinsList=new ArrayList<>();
        for(int i=0;i<splitString.length;i++){
            pinsList.add(tryParse(splitString[i]));
        }
        return 0;
    }

    private Integer tryParse(String str) throws IllegalInputException {
        int val=0;
        try{
            val= Integer.parseInt(str);
        }catch (Exception e){
            throw new IllegalInputException(str+"is not a Integer");
        }
        if(val<0||val>10){
            throw new IllegalInputException("Integer not valid : "+val);
        }
        return val;
    }
}
