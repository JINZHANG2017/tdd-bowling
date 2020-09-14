import exception.IllegalInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingGameTest {
    @Test
    void should_throw_exception_if_illegal_input(){
        assertThrows(IllegalInputException.class,()->{
            BowlingGame bowlingGame=new BowlingGame();
            String testString="1,2,3,4,5,-1,7,8,9";
            int score=bowlingGame.getScore(testString);
        });
    }

    @Test
    void should_return_300_if_all_strikes() throws IllegalInputException {
        BowlingGame bowlingGame=new BowlingGame();
        String testString="10,10,10,10,10,10,10,10,10,10,10,10";
        int score=bowlingGame.getScore(testString);
        assertEquals(300,score);
    }

    @Test
    void should_return_0_if_all_zeros() throws IllegalInputException {
        BowlingGame bowlingGame=new BowlingGame();
        String testString="0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0";
        int score=bowlingGame.getScore(testString);
        assertEquals(0,score);
    }
}
