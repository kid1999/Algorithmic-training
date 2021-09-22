/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/19 16:31
 **/
public class Test {
    public static void main(String[] args) {
//        int res = 0;
//        for (int i = 0; i <3 ; i++) {
//            for (int j = 0; j <3 ; j++) {
//                if(8-i-j >= 6) res++;
//            }
//        }
//        System.out.println(res);

        String str = "access_token=fffecec76b34e6e59ddf3de4ab51353b9ea278b1&scope=&token_type=bearer";
        String res = str.split("&")[0].split("=")[1];
        System.out.println(res);

    }
}
