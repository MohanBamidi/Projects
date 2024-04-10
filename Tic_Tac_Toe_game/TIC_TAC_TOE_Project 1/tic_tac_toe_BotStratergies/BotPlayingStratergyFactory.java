package tic_tac_toe_BotStratergies;

import tic_tac_toe_modules.Bot;
import tic_tac_toe_modules.DifficultyLevel;

public class BotPlayingStratergyFactory {
     public static BotPlayingStratergy getBotPlayingStratergy(DifficultyLevel difficultyLevel){
         if(difficultyLevel == DifficultyLevel.EASY ){
             return new EasyBotPlayingStratergy();
         }
         if(difficultyLevel == DifficultyLevel.MEDIUM){
             return  new MediumBotPlayingStratergy();
         }
         return null;
     }
}
