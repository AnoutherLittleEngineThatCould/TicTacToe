/*
 * Copyright 2015 AnoutherLittleEngineThatCould
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package ThatCould.AnoutherLittleEngine.tictactoe.component;

import ThatCould.AnoutherLittleEngine.tictactoe.model.GameTable;

import java.util.Random;

/**
 * @author AnoutherLittleEngineThatCould
 * @link github.com/AnoutherLittleEngineThatCould
 */
public class Game {
    private final DataPrinter dataPrinter;
    private final ComputerMove computerMove;
    private final UserMove userMove;
    private final WinnerVerifier winnerVerifier;
    private final DrawrVerifier drawrVerifier;

    public Game(DataPrinter dataPrinter, ComputerMove computerMove,
                UserMove userMove, WinnerVerifier winnerVerifier,
                DrawrVerifier drawrVerifier) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerVerifier = winnerVerifier;
        this.drawrVerifier = drawrVerifier;
    }

    public void play() {
        System.out.println("Use numbers from 1 to 9 to put 'X' or 'O'");

        dataPrinter.PrintMappingTable();
        final GameTable gameTable = new GameTable();
        if (new Random().nextBoolean()) {
            computerMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
        }

        while (true) {
            userMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
            if (winnerVerifier.isUserWin(gameTable)) {
                System.out.println("You WIN!");
                System.out.println("Game OVER!");
                break;
            }

            if (drawrVerifier.isDraw(gameTable)) {
                System.out.println("Draw");
                System.out.println("Game OVER!");
                break;
            }

            computerMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
            if (winnerVerifier.isComputerWin(gameTable)) {
                System.out.println("Computer WIN!");
                System.out.println("Game OVER!");
                break;
            }

            if (drawrVerifier.isDraw(gameTable)) {
                System.out.println("Draw");
                System.out.println("Game OVER!");
                break;
            }
        }


    }
}
