package Custom;

import jwtc.chess.*;
import jwtc.chess.board.ChessBoard;

/**
 * Created by McAfee on 9/16/2014.
 */
public class MainWrapper {

    public static boolean thing = true;

    public static void main(String [] args)
    {
        ChessBoard board = new ChessBoard();
        Move.makeMove(0,1);
        Move.equalPositions(15, 18);

    }


}
//@The following comments are auto-generated to save options for testing the current file
//@jcute.optionPrintOutput=true
//@jcute.optionJUnitOutputFolderName=D:\Workspaces\jcute
//@jcute.optionLogTraceAndInput=true
//@jcute.optionUseRandomInputs=true
//@jcute.optionNumberOfPaths=10000
//@jcute.optionQuickSearchThreshold=100
//@jcute.optionSearchStrategy=0
//@jcute.optionJUnitPkgName=
//@jcute.optionLogLevel=3
//@jcute.optionLogDeadlock=true
//@jcute.optionLogPath=true
//@jcute.optionGenerateJUnit=true
//@jcute.optionLogRace=true
//@jcute.optionLogAssertion=true
//@jcute.optionSequential=true
//@jcute.optionExtraOptions=
//@jcute.optionDepthForDFS=0
//@jcute.optionLogException=true
