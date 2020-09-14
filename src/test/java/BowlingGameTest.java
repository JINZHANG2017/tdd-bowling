import exception.IllegalInputException;
import org.junit.jupiter.api.Test;

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
}
