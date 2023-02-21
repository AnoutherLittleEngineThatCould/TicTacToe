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

import ThatCould.AnoutherLittleEngine.tictactoe.model.Cell;
import ThatCould.AnoutherLittleEngine.tictactoe.model.GameTable;

import java.util.Scanner;

/**
 * @author AnoutherLittleEngineThatCould
 * @link github.com/AnoutherLittleEngineThatCould
 */
public class UserMove {
    private final char[][] mapping = {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'}
    };

    public void make(final GameTable gameTable) {
        while (true) {
            final Cell cell = getUserInput();
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, 'X');
                return;
            } else {
                System.out.println("This cell isn't free!");
            }
        }
    }

    private Cell getUserInput() {
        while (true) {
            System.out.println("Enter some 1 to 9 number");
            final String userInput = new Scanner(System.in).nextLine();
            if (userInput.length() == 1) {
                final char userInputChar = userInput.charAt(0);
                if (userInputChar >= '1' && userInputChar <= '9') {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (mapping[i][j] == userInputChar) {
                                return new Cell(i, j);
                            }
                        }

                    }
                }
            }
        }
    }
}
