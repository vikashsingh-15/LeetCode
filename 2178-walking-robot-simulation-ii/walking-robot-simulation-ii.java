// class Robot {

//     private boolean moved = false;
//     String[] directions = {"East", "North", "West", "South"};

//     int x = 0, y = 0;
//     int dir = 0;
//     int width, height;

//     public Robot(int width, int height) {
//         this.width = width;
//         this.height = height;
//     }
    
//     public void step(int num) {

//         int perimeter = 2 * (width + height) - 4;
//         num = num % perimeter;

//         if (num == 0 && moved) {
//             dir = 3; 
//             return;
//         }

//         moved = true;

//         while (num > 0) {

//             if (dir == 0) { 
//                 int move = Math.min(num, width - 1 - x);
//                 x += move;
//                 num -= move;
//                 if (num > 0) dir = 1;

//             } else if (dir == 1) { 
//                 int move = Math.min(num, height - 1 - y);
//                 y += move;
//                 num -= move;
//                 if (num > 0) dir = 2;

//             } else if (dir == 2) { 
//                 int move = Math.min(num, x);
//                 x -= move;
//                 num -= move;
//                 if (num > 0) dir = 3;

//             } else { 
//                 int move = Math.min(num, y);
//                 y -= move;
//                 num -= move;
//                 if (num > 0) dir = 0;
//             }
//         }
//     }
    
//     public int[] getPos() {
//         return new int[]{x, y};
//     }
    
//     public String getDir() {
//         return directions[dir];
//     }
// }



///way 2
class Robot {

    int width, height;
    int pos = 0;
    int perimeter;
    boolean moved = false;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
    }
    
    public void step(int num) {
        moved = true;
        pos = (pos + num) % perimeter;
    }
    
    public int[] getPos() {

        int p = pos;

        if (p < width - 1) {
            return new int[]{p, 0};
        }

        p -= (width - 1);

        if (p < height - 1) {
            return new int[]{width - 1, p};
        }

        p -= (height - 1);

        if (p < width - 1) {
            return new int[]{width - 1 - p, height - 1};
        }

        p -= (width - 1);

        return new int[]{0, height - 1 - p};
    }
    
    public String getDir() {

    if (!moved) return "East";

    if (pos == 0) return "South";

    int bottom = width - 1;
    int right = height - 1;
    int top = width - 1;

    if (pos < bottom) return "East";

    if (pos == bottom) return "East"; // 🔥 FIX (corner)

    if (pos < bottom + right) return "North";

    if (pos == bottom + right) return "North"; // corner

    if (pos < bottom + right + top) return "West";

    if (pos == bottom + right + top) return "West"; // corner

    return "South";
}
}