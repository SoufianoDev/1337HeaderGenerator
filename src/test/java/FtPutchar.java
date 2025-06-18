/* ************************************************************************************ */
/*                                                                                      */
/*                                                                                      */
/*   FtPutchar.java                                  +#::     +####:   +####:   ######  */
/*                                                   ##::     #::::#   #::::#       #:  */
/*   By: Soufiano <soufiano@student.1337.ma>          #::         #:       #:      #:   */
/*                                                    #::     +###:    +###:     #:     */
/*   Created: 2025/06/17 02:34:00 by Soufiano         #::         #:       #:   #:      */
/*   Updated: 2025/06/17 03:00:00 by Soufiano         #::     #::::#   #:::::  #:       */
/*                                                  #######   +####:  +####:  #.ma      */
/*                                                                                      */
/* ************************************************************************************ */


public class FtPutchar {
    public static void ft_putchar(char c) {
        try {
            System.out.write(c);
            System.out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
