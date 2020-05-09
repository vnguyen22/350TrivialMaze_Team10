/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviamenu;

import javafx.animation.AnimationTimer;
import javafx.scene.control.TextArea;

/**
 *
 * @author Gingervitis
 */
public class Intro {
    
    private static long mStartTime = System.currentTimeMillis();
    private static AnimationTimer mTimer;
    
    public static void runIntro(TextArea area){
        final ASCIIArtObject WELCOME = new ASCIIArtObject("░██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗",
                                                          "░██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝",
                                                          "░╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░",
                                                          "░░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░",
                                                          "░░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗",
                                                          "░░░╚═╝░░░╚═╝░░╚══════╝╚══════╝░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝");
        final ASCIIArtObject TO = new ASCIIArtObject("████████╗░█████╗░",
                                                     "╚══██╔══╝██╔══██╗",
                                                     "░░░██║░░░██║░░██║",
                                                     "░░░██║░░░██║░░██║",
                                                     "░░░██║░░░╚█████╔╝",
                                                     "░░░╚═╝░░░░╚════╝░");
        final ASCIIArtObject TRIVIA = new ASCIIArtObject("████████╗██████╗░██╗██╗░░░██╗██╗░█████╗░",
                                                         "╚══██╔══╝██╔══██╗██║██║░░░██║██║██╔══██╗",
                                                         "░░░██║░░░██████╔╝██║╚██╗░██╔╝██║███████║",
                                                         "░░░██║░░░██╔══██╗██║░╚████╔╝░██║██╔══██║",
                                                         "░░░██║░░░██║░░██║██║░░╚██╔╝░░██║██║░░██║",
                                                         "░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░░╚═╝░░░╚═╝╚═╝░░╚═╝");
        final ASCIIArtObject MAZE = new ASCIIArtObject("███╗░░░███╗░█████╗░███████╗███████╗██╗",
                                                       "████╗░████║██╔══██╗╚════██║██╔════╝██║",
                                                       "██╔████╔██║███████║░░███╔═╝█████╗░░██║",
                                                       "██║╚██╔╝██║██╔══██║██╔══╝░░██╔══╝░░╚═╝",
                                                       "██║░╚═╝░██║██║░░██║███████╗███████╗██╗",
                                                       "╚═╝░░░░░╚═╝╚═╝░░╚═╝╚══════╝╚══════╝╚═╝");
        
        mTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onTimer(now);   
            }

            private void onTimer(long now) {
                now = System.currentTimeMillis();
                long elapsed = (now-mStartTime);
                if (elapsed >= 500 && elapsed < 1500){
                     area.setText(WELCOME.toString());
                }
                else if (elapsed >= 1500 && elapsed < 2500){
                    area.setText(WELCOME.toString() + TO.toString());
                }
                else if (elapsed >= 2500 && elapsed < 3500){
                    area.setText(WELCOME.toString() + TO.toString() + TRIVIA.toString());
                }
                else if (elapsed >= 3500){
                    area.setText(WELCOME.toString() + TO.toString() + TRIVIA.toString() + MAZE.toString());
                }
                if (elapsed >= 5500){
                    area.clear();
                    mTimer.stop();
                }
            }
        };
        mTimer.start();
    }
    
}
