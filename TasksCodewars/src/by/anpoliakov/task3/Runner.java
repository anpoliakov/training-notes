package by.anpoliakov.task3;

/*
* Тимми и Сара думают, что они влюблены, но в районе, где они живут, они узнают это только после того,
* как сорвут по цветку каждый. Если у одного из цветов четное количество лепестков, а у другого нечетное,
* это означает, что они влюблены.
* */
public class Runner {
    public static void main(String[] args) {
        System.out.println(isLove(2,6));
        System.out.println(isLove2(2,6));
    }

    //stupid solution
    private static boolean isLove(final int flower1, final int flower2) {
        boolean flag = false;

        if((flower1 % 2 == 0 && flower2 % 2 != 0) || (flower1 % 2 != 0 && flower2 % 2 == 0)){
            flag = true;
        }

        return flag;
    }

    //smart solution
    private static boolean isLove2(final int flower1, final int flower2) {
        return flower1 % 2 != flower2 % 2;
    }
}
