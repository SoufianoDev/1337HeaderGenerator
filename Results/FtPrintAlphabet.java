/* ************************************************************************************ */
/*                                                                                      */
/*                                                                                      */
/*   FtPrintAlphabet.java                            +#::     +####:   +####:   ######  */
/*                                                   ##::     #::::#   #::::#       #:  */
/*   By: Soufiano <soufiano@student.1337.ma>          #::         #:       #:      #:   */
/*                                                    #::     +###:    +###:     #:     */
/*   Created: 2025/06/17 02:34:00 by Soufiano         #::         #:       #:   #:      */
/*   Updated: 2025/06/17 03:00:00 by Soufiano         #::     #::::#   #:::::  #:       */
/*                                                  #######   +####:  +####:  #.ma      */
/*                                                                                      */
/* ************************************************************************************ */

public class FtPrintAlphabet {

    public static void ft_print_alphabet() {
        char alpha = 'a';
        while (alpha <= 'z') {
            try {
                System.out.write(alpha);
            } catch (Exception e) {
                e.printStackTrace();
            }
            /home/soufiano/SoufianoDev/1337Days/C00
        }
        System.out.flush();
    }
}
