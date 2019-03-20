package baemincodetest;

public class Question2 {

    public static void main(String[] args){
        int[][] lands = {{10, 0, 30, 5}, {0, 30, 20, 50}, {30, 30, 40, 40}};
        int[][] wells = {{15, 15, 25, 25}, {40, 10, 50, 20}};
        int[] point = {10, 10, 30, 30};

        solution(lands, wells, point);
    }

    public static boolean solution(int[][] lands, int[][] wells, int[] point) {

        return (includeWells(wells, point) && includeLands(lands, point));

    }

    public static boolean includeWells(int[][] wells, int[] point){

        int x1 = point[0];
        int y1 = point[1];
        int x2 = point[2];
        int y2 = point[3];
        int wx1, wy1, wx2, wy2;

        for(int i=0;i<wells.length;i++){
            wx1 = wells[i][0];
            wy1 = wells[i][1];
            wx2 = wells[i][2];
            wy2 = wells[i][3];
            if((x1<=wx1 && y1<=wy1) && (x2>=wx2 && y2>=wy2)) {
                System.out.println("우물 포함됨");
                return true;
            }
        }
        return false;
    }

    public static boolean includeLands(int[][] lands, int[] point){
        int x1 = point[0];
        int y1 = point[1];
        int x2 = point[2];
        int y2 = point[3];
        int lx1, ly1, lx2, ly2;
        for(int i=0;i<lands.length;i++){
            lx1 = lands[i][0];
            ly1 = lands[i][1];
            lx2 = lands[i][2];
            ly2 = lands[i][3];

            if(((x1 < lx2 && lx2 < x2) || (x1 < lx1 && lx1 < x2)) && ((y1 < ly1 && ly1 < y2) || (y1 < ly2 && ly2 < y2))){
                return false;
            }
        }
        return true;
    }
}
