/* ************************************************************************************ */
/*                                                                                      */
/*                                                                                      */
/*   Main.java                                       +#::     +####:   +####:   ######  */
/*                                                   ##::     #::::#   #::::#       #:  */
/*   By: Soufiano <soufiano@student.1337.ma>          #::         #:       #:      #:   */
/*                                                    #::     +###:    +###:     #:     */
/*   Created: 2025/06/17 02:34:00 by Soufiano         #::         #:       #:   #:      */
/*   Updated: 2025/06/17 03:00:00 by Soufiano         #::     #::::#   #:::::  #:       */
/*                                                  #######   +####:  +####:  #.ma      */
/*                                                                                      */
/* ************************************************************************************ */

package com.soufianodev;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LeetHeaderGenerator generator = new LeetHeaderGenerator();
        generator.setStudentData("SoufianoDev", "soufianodev@student.1337.ma");
        generator.addHeaderToAllProjectFiles(".java",".c");
    }
}
