    package zero;

    import java.util.Scanner;

    public class SwapPlindrome {
        public static void main(String args[]){
            Scanner s = new Scanner(System.in);
            String str = s.nextLine();
            int t = Integer.parseInt(str);
            while(t>0){
                t--;
                 str = s.nextLine();
                str=str.toUpperCase();
                char[]a= str.toCharArray();
                int size = a.length;
                int count=0;
                char chr = ' ';
                char chr2 = ' ';
                String res = "Yes";
                boolean flag = false;
                if(size==2 && a[0]!=a[1]){
                    res="No";
                }
                else {
                    for (int i = 0, j = size - 1; i < j; i++, j--) {

                        if (a[i] != a[j]) {
                            count++;
                            if (count == 2 && chr == a[j] && chr2 == a[i]) {
                                flag = true;
                            } else if (count == 1) {
                                chr = a[i];
                                chr = a[j];
                            }
                        }
                        if (count > 2) {
                            res = "No";
                            break;
                        } else if (count == 2 && !flag) {
                            res = "No";
                            break;
                        }
                    }
                }
                System.out.println(res);
            }
        }
    }
