import exception.IllegalInputException;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public int getScore(String testString) throws IllegalInputException {
        String[] splitString = testString.split(",");
        if (splitString.length < 10) {
            throw new IllegalInputException("numbers less than 10");
        }
        List<Integer> pinsList = new ArrayList<>();
        for (int i = 0; i < splitString.length; i++) {
            pinsList.add(tryParse(splitString[i]));
        }
        List<BowlingShot> bowlingShotList = getBowlingShotList(pinsList);
        int score=getFinalScore(bowlingShotList);
        return score;
    }

    private int getFinalScore(List<BowlingShot> bowlingShotList) {
        int finalScore=0;
        for(int i=0;i<bowlingShotList.size();i++){
            BowlingShot bowlingShot=bowlingShotList.get(i);
            if(bowlingShot.isStrike()&&i>bowlingShotList.size()-3){
                //the last two
                if(i==9){
                    finalScore+=(10+bowlingShot.getExtras()[0]+bowlingShot.getExtras()[1]);
                }
                if(i==8){
                    BowlingShot nextShot=bowlingShotList.get(9);
                    if(nextShot.isStrike()){
                        finalScore+=(20+nextShot.getExtras()[0]);
                    }else{
                        finalScore+=(10+nextShot.getTwoSumPins());
                    }
                }
                continue;
            }
            if(bowlingShot.isSpare()&&i==9){
                finalScore+=(10+bowlingShot.getExtras()[0]);
                continue;
            }
            if(bowlingShot.isStrike()){
                BowlingShot nextOneShot=bowlingShotList.get(i+1);
                BowlingShot nextTwoShot=bowlingShotList.get(i+2);
                if(!nextOneShot.isStrike()){
                    finalScore+=(10+nextOneShot.getTwoSumPins());
                }else {
                    finalScore+=(10+10+nextTwoShot.getFirstPins());
                }
            }else if(bowlingShot.isSpare()){
                BowlingShot nextOneShot=bowlingShotList.get(i+1);
                finalScore+=(10+nextOneShot.getFirstPins());
            }else{
                finalScore+=(bowlingShot.getTwoSumPins());
            }
        }
        return finalScore;
    }

    private List<BowlingShot> getBowlingShotList(List<Integer> pinsList) {
        List<BowlingShot> bowlingShotList = new ArrayList<>();
        int pinListIndex = 0;
        for (int i = 0; i < 10; i++) {
            int pins = pinsList.get(pinListIndex);
            if (pins == 10) {
                bowlingShotList.add(new BowlingShot(10));
                pinListIndex++;
            } else {
                bowlingShotList.add(new BowlingShot(pinsList.get(pinListIndex),pinsList.get(pinListIndex+1)));
                pinListIndex+=2;
            }
            if(i==9){
                List<Integer> extraPins=new ArrayList<>();
                for(int j=pinListIndex;j<pinsList.size();j++){
                    extraPins.add(pinsList.get(j));
                }
                Integer[] extranPinsArray=new Integer[extraPins.size()];
                extraPins.toArray(extranPinsArray);
                bowlingShotList.get(9).setExtras(extranPinsArray);
            }
        }
        return bowlingShotList;
    }

    private Integer tryParse(String str) throws IllegalInputException {
        int val = 0;
        try {
            val = Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalInputException(str + "is not a Integer");
        }
        if (val < 0 || val > 10) {
            throw new IllegalInputException("Integer not valid : " + val);
        }
        return val;
    }
}
