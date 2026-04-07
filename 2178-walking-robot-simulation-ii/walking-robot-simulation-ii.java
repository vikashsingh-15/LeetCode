/// way 1
// class Robot {

//     int width, height;
//     int pos = 0;
//     int perimeter;
//     boolean moved = false;

//     public Robot(int width, int height) {
//         this.width = width;
//         this.height = height;
//         this.perimeter = 2 * (width + height) - 4;
//     }

//     public void step(int num) {
//         moved = true;
//         pos = (pos + num) % perimeter;
//     }

//     public int[] getPos() {

//         int p = pos;

//         if (p <= width - 1) {
//             return new int[] { p, 0 };
//         }

//         p -= (width - 1);

//         if (p <= height - 1) {
//             return new int[] { width - 1, p };
//         }

//         p -= (height - 1);

//         if (p <= width - 1) {
//             return new int[] { width - 1 - p, height - 1 };
//         }

//         p -= (width - 1);

//         return new int[] { 0, height - 1 - p };
//     }

//     public String getDir() {

//         if (!moved)
//             return "East";

//         if (pos == 0)
//             return "South";

//         int bottom = width - 1;
//         int right = height - 1;
//         int top = width - 1;

//         if (pos <= width-1)
//             return "East";

//         if (pos <= bottom + right)
//             return "North";

//         if (pos <= bottom + right + top)
//             return "West";


//         return "South";
//     }
// }



//way2
class Robot {
    private boolean moved = false;
    private int idx = 0;
    private List<int[]> pos = new ArrayList<>();
    private List<String> dir = new ArrayList<>();

    public Robot(int width, int height) {

        for (int i = 0; i < width; i++) {
            pos.add(new int[]{i, 0});
            dir.add("East");
        }

        for (int i = 1; i < height; i++) {
            pos.add(new int[]{width - 1, i});
            dir.add("North");
        }

        for (int i = width - 2; i >= 0; i--) {
            pos.add(new int[]{i, height - 1});
            dir.add("West");
        }

        for (int i = height - 2; i > 0; i--) {
            pos.add(new int[]{0, i}); 
            dir.add("South");
        }
    }

    public void step(int num) {
        moved = true;
        idx = (idx + num) % pos.size();
    }

    public int[] getPos() {
        return pos.get(idx);
    }

    public String getDir() {

        if (!moved) return "East";
        if (idx == 0) return "South";

        return dir.get(idx);
    }
}