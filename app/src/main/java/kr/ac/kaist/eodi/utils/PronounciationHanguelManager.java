package kr.ac.kaist.eodi.utils;

/**
 * Created by yearnning on 15. 6. 1..
 */
public class PronounciationHanguelManager {

    private static int[] cho = {0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 3, 3, 3, 0, 1, 2, 4};
    private static int[] jung = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2};
    private static int[] jong = {0, 1, 1, 1, 2, 2, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 6, 6, 3, 3, 7, 3, 3, 3, 3, 6, 3};

    /**
     * return 0~100
     *
     * @param a
     * @param b
     * @return
     */
    public static int similarityCho(int a, int b) {

        /**
         *
         */
        if (a == b) {
            return 100;
        }

        /**
         *
         */
        if (sameCho(a, b)) {
            return 75;
        }

        /**
         *
         */
        return 0;
    }

    private static boolean sameCho(int a, int b) {
        if (cho[a] == cho[b]) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * return 0~100
     *
     * @param a
     * @param b
     * @return
     */
    public static int similarityJung(int a, int b) {

        /**
         *
         */
        if (a == b) {
            return 100;
        }

        /**
         *
         */
        if (sameJung(a, b)) {
            return 75;
        }

        /**
         *
         */
        return 0;
    }

    private static boolean sameJung(int a, int b) {
        if (jung[a] == jung[b]) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * return 0~100
     *
     * @param a
     * @param b
     * @return
     */
    public static int similarityJong(int a, int b) {
        /**
         *
         */
        if (a == b) {
            return 100;
        }

        /**
         *
         */
        if (sameJong(a, b)) {
            return 75;
        }

        /**
         *
         */
        return 0;
    }

    private static boolean sameJong(int a, int b) {
        if (jong[a] == jong[b]) {
            return true;
        } else {
            return false;
        }
    }
}
