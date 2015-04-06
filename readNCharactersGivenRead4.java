/* The read4 API is defined in the parent class Reader4.

      int read4(char[] buf); */



public class Solution extends Reader4 {

    /**

     * @param buf Destination buffer

     * @param n   Maximum number of characters to read

     * @return    The number of characters read

     */

    public int read(char[] buf, int n) {

        int i = 0;

        char[] array = new char[4];

        boolean eof = false;

        while(!eof && i < n)

        {

            int num = read4(array);

            if(num < 4)

            {

                eof = true;

            }

            int bytes = Math.min(num,n-i);

            System.arraycopy(array,0,buf,i,bytes);

                i = i + bytes;

        }

        return i;

    }

}
